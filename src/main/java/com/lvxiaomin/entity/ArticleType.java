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
 * @TableName article_type
 */
@TableName(value ="article_type")
@Data
public class ArticleType implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer typeId;

    /**
     * 
     */
    private Integer articleNum;

    /**
     * 
     */
    private String typeCreateTime;

    /**
     * 
     */
    private String typeDesc;

    /**
     * 
     */
    private String typeName;

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
        ArticleType other = (ArticleType) that;
        return (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getArticleNum() == null ? other.getArticleNum() == null : this.getArticleNum().equals(other.getArticleNum()))
            && (this.getTypeCreateTime() == null ? other.getTypeCreateTime() == null : this.getTypeCreateTime().equals(other.getTypeCreateTime()))
            && (this.getTypeDesc() == null ? other.getTypeDesc() == null : this.getTypeDesc().equals(other.getTypeDesc()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getArticleNum() == null) ? 0 : getArticleNum().hashCode());
        result = prime * result + ((getTypeCreateTime() == null) ? 0 : getTypeCreateTime().hashCode());
        result = prime * result + ((getTypeDesc() == null) ? 0 : getTypeDesc().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", articleNum=").append(articleNum);
        sb.append(", typeCreateTime=").append(typeCreateTime);
        sb.append(", typeDesc=").append(typeDesc);
        sb.append(", typeName=").append(typeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}