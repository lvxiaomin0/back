package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName admin
 */
@Data
@TableName(value ="admin")
public class Admin implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer adminId;

    /**
     * 
     */
    private String adminLoginName;

    /**
     * 
     */
    private String adminLoginPassword;

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
        Admin other = (Admin) that;
        return (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getAdminLoginName() == null ? other.getAdminLoginName() == null : this.getAdminLoginName().equals(other.getAdminLoginName()))
            && (this.getAdminLoginPassword() == null ? other.getAdminLoginPassword() == null : this.getAdminLoginPassword().equals(other.getAdminLoginPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getAdminLoginName() == null) ? 0 : getAdminLoginName().hashCode());
        result = prime * result + ((getAdminLoginPassword() == null) ? 0 : getAdminLoginPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", adminLoginName=").append(adminLoginName);
        sb.append(", adminLoginPassword=").append(adminLoginPassword);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}