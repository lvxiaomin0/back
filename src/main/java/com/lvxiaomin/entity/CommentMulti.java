package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comment_multi
 */
@TableName(value ="comment_multi")
@Data
public class CommentMulti implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer comMultiId;

    /**
     * 
     */
    private Long comId;

    /**
     * 
     */
    private String comMultiContent;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private Date comMultiTime;

    /**
     * 
     */
    private Long comMultiUserId;

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
        CommentMulti other = (CommentMulti) that;
        return (this.getComMultiId() == null ? other.getComMultiId() == null : this.getComMultiId().equals(other.getComMultiId()))
            && (this.getComId() == null ? other.getComId() == null : this.getComId().equals(other.getComId()))
            && (this.getComMultiContent() == null ? other.getComMultiContent() == null : this.getComMultiContent().equals(other.getComMultiContent()))
            && (this.getComMultiTime() == null ? other.getComMultiTime() == null : this.getComMultiTime().equals(other.getComMultiTime()))
            && (this.getComMultiUserId() == null ? other.getComMultiUserId() == null : this.getComMultiUserId().equals(other.getComMultiUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getComMultiId() == null) ? 0 : getComMultiId().hashCode());
        result = prime * result + ((getComId() == null) ? 0 : getComId().hashCode());
        result = prime * result + ((getComMultiContent() == null) ? 0 : getComMultiContent().hashCode());
        result = prime * result + ((getComMultiTime() == null) ? 0 : getComMultiTime().hashCode());
        result = prime * result + ((getComMultiUserId() == null) ? 0 : getComMultiUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", comMultiId=").append(comMultiId);
        sb.append(", comId=").append(comId);
        sb.append(", comMultiContent=").append(comMultiContent);
        sb.append(", comMultiTime=").append(comMultiTime);
        sb.append(", comMultiUserId=").append(comMultiUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}