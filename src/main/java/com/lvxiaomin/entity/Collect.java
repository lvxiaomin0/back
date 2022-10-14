package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName collect
 */
@TableName(value ="collect")
@Data
public class Collect implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer colId;

    /**
     * 
     */
    private Long colArtId;

    /**
     * 
     */
    private Long colUserId;

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
        Collect other = (Collect) that;
        return (this.getColId() == null ? other.getColId() == null : this.getColId().equals(other.getColId()))
            && (this.getColArtId() == null ? other.getColArtId() == null : this.getColArtId().equals(other.getColArtId()))
            && (this.getColUserId() == null ? other.getColUserId() == null : this.getColUserId().equals(other.getColUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getColId() == null) ? 0 : getColId().hashCode());
        result = prime * result + ((getColArtId() == null) ? 0 : getColArtId().hashCode());
        result = prime * result + ((getColUserId() == null) ? 0 : getColUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", colId=").append(colId);
        sb.append(", colArtId=").append(colArtId);
        sb.append(", colUserId=").append(colUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}