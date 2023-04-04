package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName admin_up
 */
@TableName(value ="admin_up")
@Data
public class AdminUp implements Serializable {
    /**
     * 管理员上传文件ID
     */
    @TableId(type = IdType.AUTO)
    private Integer upId;

    /**
     * 上传文件url
     */
    private String upFileUrl;

    /**
     * 上传时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String upTime;

    /**
     * 文件名
     */

    private String upFileName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdminUp other = (AdminUp) that;
        return (this.getUpId() == null ? other.getUpId() == null : this.getUpId().equals(other.getUpId()))
            && (this.getUpFileUrl() == null ? other.getUpFileUrl() == null : this.getUpFileUrl().equals(other.getUpFileUrl()))
            && (this.getUpTime() == null ? other.getUpTime() == null : this.getUpTime().equals(other.getUpTime()))
            && (this.getUpFileName() == null ? other.getUpFileName() == null : this.getUpFileName().equals(other.getUpFileName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUpId() == null) ? 0 : getUpId().hashCode());
        result = prime * result + ((getUpFileUrl() == null) ? 0 : getUpFileUrl().hashCode());
        result = prime * result + ((getUpTime() == null) ? 0 : getUpTime().hashCode());
        result = prime * result + ((getUpFileName() == null) ? 0 : getUpFileName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", upId=").append(upId);
        sb.append(", upFileUrl=").append(upFileUrl);
        sb.append(", upTime=").append(upTime);
        sb.append(", upFileName=").append(upFileName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}