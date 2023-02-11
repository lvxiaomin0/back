package com.lvxiaomin.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 腾讯云存储桶 Cos
 * @Author: Ming
 * @Date: 2023/2/1 20:46
 */
@Component
public class TencentCosUtil {

    private static String secretId;
    private static String secretKey;
    private static String bucketName;
    private static String accessUrl;

    @Value("${tencentCosUtil.secretId}")
    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    @Value("${tencentCosUtil.secretKey}")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Value("${tencentCosUtil.bucketName}")
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @Value("${tencentCosUtil.accessUrl}")
    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    /**
     * 上传文件
     *
     * @param fileMul
     * @return
     * @throws Exception
     */
    public static String uploadFile(MultipartFile fileMul) throws Exception {
        //临时文件路径(自定义)
        String temporaryFile = "image";
        //效验临时文件是否存在

        File localFile = new File(temporaryFile);
        if (!localFile.exists()) {
            //临时文件不存在，创造临时文件
            localFile.mkdirs();
        }
        //创造临时文件名称
        String fileName = fileMul.getOriginalFilename();
        String name = "/" + RandomStringUtils.randomNumeric(6) + System.currentTimeMillis() + System.nanoTime() + RandomStringUtils.randomNumeric(6) + fileName.substring(fileName.lastIndexOf('.'));
        //创造临时文件图片
        temporaryFile = temporaryFile + name;
        FileOutputStream fos;
        fos = new FileOutputStream(temporaryFile);
        fos.write(fileMul.getBytes());
        fos.flush();
        fos.close();
        // 使用COS
        File file = new File(temporaryFile);
        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID和SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        //格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, temporaryFile + sdf.format(new Date()) + name, file);
        cosClient.putObject(putObjectRequest);
        String saveUrl = accessUrl + putObjectRequest.getKey();
        // 删除用户上传临时文件
        File localImgFile = new File(temporaryFile);
        localImgFile.delete();
        return saveUrl;
    }
}
