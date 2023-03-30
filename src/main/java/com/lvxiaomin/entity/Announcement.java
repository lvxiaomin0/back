package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName announcement
 */
@TableName(value ="announcement")
@Data
public class Announcement implements Serializable {
    /**
     * 流动消息ID
     */
    @TableId(type = IdType.AUTO)
    private Integer moId;

    /**
     * 流动消息内容
     */
    private String moContent;

    /**
     * 发布时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String moTime;

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
        Announcement other = (Announcement) that;
        return (this.getMoId() == null ? other.getMoId() == null : this.getMoId().equals(other.getMoId()))
            && (this.getMoContent() == null ? other.getMoContent() == null : this.getMoContent().equals(other.getMoContent()))
            && (this.getMoTime() == null ? other.getMoTime() == null : this.getMoTime().equals(other.getMoTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMoId() == null) ? 0 : getMoId().hashCode());
        result = prime * result + ((getMoContent() == null) ? 0 : getMoContent().hashCode());
        result = prime * result + ((getMoTime() == null) ? 0 : getMoTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moId=").append(moId);
        sb.append(", moContent=").append(moContent);
        sb.append(", moTime=").append(moTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}