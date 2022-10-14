package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName attention
 */
@TableName(value ="attention")
@Data
public class Attention implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer attId;

    /**
     * 
     */
    private Long attAuthorId;

    /**
     * 
     */
    private Long attUserId;

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
        Attention other = (Attention) that;
        return (this.getAttId() == null ? other.getAttId() == null : this.getAttId().equals(other.getAttId()))
            && (this.getAttAuthorId() == null ? other.getAttAuthorId() == null : this.getAttAuthorId().equals(other.getAttAuthorId()))
            && (this.getAttUserId() == null ? other.getAttUserId() == null : this.getAttUserId().equals(other.getAttUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttId() == null) ? 0 : getAttId().hashCode());
        result = prime * result + ((getAttAuthorId() == null) ? 0 : getAttAuthorId().hashCode());
        result = prime * result + ((getAttUserId() == null) ? 0 : getAttUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attId=").append(attId);
        sb.append(", attAuthorId=").append(attAuthorId);
        sb.append(", attUserId=").append(attUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}