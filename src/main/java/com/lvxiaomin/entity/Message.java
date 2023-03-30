package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName message
 */
@TableName(value ="message")
@Data
public class Message implements Serializable {
    /**
     * 留言ID
     */
    @TableId(type = IdType.AUTO)
    private Long mId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 内容
     */
    private String mContent;

    /**
     * 时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String mTime;

    /**
     * 用户昵称
     */
    private String mNickname;

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
        Message other = (Message) that;
        return (this.getMId() == null ? other.getMId() == null : this.getMId().equals(other.getMId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getMContent() == null ? other.getMContent() == null : this.getMContent().equals(other.getMContent()))
                && (this.getMTime() == null ? other.getMTime() == null : this.getMTime().equals(other.getMTime()))
                && (this.getMNickname() == null ? other.getMNickname() == null : this.getMNickname().equals(other.getMNickname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMId() == null) ? 0 : getMId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMContent() == null) ? 0 : getMContent().hashCode());
        result = prime * result + ((getMTime() == null) ? 0 : getMTime().hashCode());
        result = prime * result + ((getMNickname() == null) ? 0 : getMNickname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mId=").append(mId);
        sb.append(", userId=").append(userId);
        sb.append(", mContent=").append(mContent);
        sb.append(", mTime=").append(mTime);
        sb.append(", mNickname=").append(mNickname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}