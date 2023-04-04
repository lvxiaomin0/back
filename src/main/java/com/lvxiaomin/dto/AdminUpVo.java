package com.lvxiaomin.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: Ming
 * @Date: 2023/4/4 11:06
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpVo {
    /**
     * 上传文件url
     */
    @NotEmpty(message = "Could Not Empty")
    @JsonProperty(value = "upFileUrl")
    private String upFileUrl;

    /**
     * 文件名
     */
    @NotEmpty(message = "Could Not Empty")
    @JsonProperty(value = "upFileName")
    private String upFileName;
}
