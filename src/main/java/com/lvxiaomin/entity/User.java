package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 
     */
    private String userBlog;

    /**
     * 
     */
    private Integer userConcern;

    /**
     * 
     */
    private String userEmail;

    /**
     * 
     */
    private Integer userFans;

    /**
     * 
     */
    private String userImg;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String userPassword;

    /**
     * 
     */
    private String userPhone;

    /**
     * 
     */
    private String userSex;

    /**
     * 
     */
    private String userShow;

    /**
     * 
     */
    private Integer userStatus;

    /**
     * 
     */
    private Date userTime;

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
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserBlog() == null ? other.getUserBlog() == null : this.getUserBlog().equals(other.getUserBlog()))
            && (this.getUserConcern() == null ? other.getUserConcern() == null : this.getUserConcern().equals(other.getUserConcern()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getUserFans() == null ? other.getUserFans() == null : this.getUserFans().equals(other.getUserFans()))
            && (this.getUserImg() == null ? other.getUserImg() == null : this.getUserImg().equals(other.getUserImg()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
            && (this.getUserShow() == null ? other.getUserShow() == null : this.getUserShow().equals(other.getUserShow()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
            && (this.getUserTime() == null ? other.getUserTime() == null : this.getUserTime().equals(other.getUserTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserBlog() == null) ? 0 : getUserBlog().hashCode());
        result = prime * result + ((getUserConcern() == null) ? 0 : getUserConcern().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getUserFans() == null) ? 0 : getUserFans().hashCode());
        result = prime * result + ((getUserImg() == null) ? 0 : getUserImg().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getUserShow() == null) ? 0 : getUserShow().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getUserTime() == null) ? 0 : getUserTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userBlog=").append(userBlog);
        sb.append(", userConcern=").append(userConcern);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userFans=").append(userFans);
        sb.append(", userImg=").append(userImg);
        sb.append(", userName=").append(userName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userSex=").append(userSex);
        sb.append(", userShow=").append(userShow);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", userTime=").append(userTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}