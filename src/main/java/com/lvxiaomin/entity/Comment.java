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
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer comId;

    /**
     * 
     */
    private Long comArtId;

    /**
     * 
     */
    private String comContent;

    /**
     * 
     */
    private Date comTime;

    /**
     * 
     */
    private Long comUserId;

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
        Comment other = (Comment) that;
        return (this.getComId() == null ? other.getComId() == null : this.getComId().equals(other.getComId()))
            && (this.getComArtId() == null ? other.getComArtId() == null : this.getComArtId().equals(other.getComArtId()))
            && (this.getComContent() == null ? other.getComContent() == null : this.getComContent().equals(other.getComContent()))
            && (this.getComTime() == null ? other.getComTime() == null : this.getComTime().equals(other.getComTime()))
            && (this.getComUserId() == null ? other.getComUserId() == null : this.getComUserId().equals(other.getComUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getComId() == null) ? 0 : getComId().hashCode());
        result = prime * result + ((getComArtId() == null) ? 0 : getComArtId().hashCode());
        result = prime * result + ((getComContent() == null) ? 0 : getComContent().hashCode());
        result = prime * result + ((getComTime() == null) ? 0 : getComTime().hashCode());
        result = prime * result + ((getComUserId() == null) ? 0 : getComUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", comId=").append(comId);
        sb.append(", comArtId=").append(comArtId);
        sb.append(", comContent=").append(comContent);
        sb.append(", comTime=").append(comTime);
        sb.append(", comUserId=").append(comUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}