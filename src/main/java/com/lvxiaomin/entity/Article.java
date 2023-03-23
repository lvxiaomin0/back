package com.lvxiaomin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer artId;

    /**
     * 
     */
    private Integer artComNum;

    /**
     * 
     */
    private Long artCommentId;

    /**
     * 
     */
    private String artContent;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private String artCreTime;

    /**
     * 
     */
    private Integer artHotNum;

    /**
     * 
     */
    private Integer artLikeNum;

    /**
     * 
     */
    private String artTitle;

    /**
     * 
     */
    private Long artTypeId;

    /**
     * 
     */
    private Long artUserId;

    /**
     * 
     */
    private Integer artView;
    /**
     *
     */

    private String artImage;

    @TableField(exist = false)
    private Map<String,User> map;
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
        Article other = (Article) that;
        return (this.getArtId() == null ? other.getArtId() == null : this.getArtId().equals(other.getArtId()))
            && (this.getArtComNum() == null ? other.getArtComNum() == null : this.getArtComNum().equals(other.getArtComNum()))
            && (this.getArtCommentId() == null ? other.getArtCommentId() == null : this.getArtCommentId().equals(other.getArtCommentId()))
            && (this.getArtContent() == null ? other.getArtContent() == null : this.getArtContent().equals(other.getArtContent()))
            && (this.getArtCreTime() == null ? other.getArtCreTime() == null : this.getArtCreTime().equals(other.getArtCreTime()))
            && (this.getArtHotNum() == null ? other.getArtHotNum() == null : this.getArtHotNum().equals(other.getArtHotNum()))
            && (this.getArtLikeNum() == null ? other.getArtLikeNum() == null : this.getArtLikeNum().equals(other.getArtLikeNum()))
            && (this.getArtTitle() == null ? other.getArtTitle() == null : this.getArtTitle().equals(other.getArtTitle()))
            && (this.getArtTypeId() == null ? other.getArtTypeId() == null : this.getArtTypeId().equals(other.getArtTypeId()))
            && (this.getArtUserId() == null ? other.getArtUserId() == null : this.getArtUserId().equals(other.getArtUserId()))
            && (this.getArtView() == null ? other.getArtView() == null : this.getArtView().equals(other.getArtView()))
                && (this.getArtImage() == null ? other.getArtImage() == null : this.getArtImage().equals(other.getArtImage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArtId() == null) ? 0 : getArtId().hashCode());
        result = prime * result + ((getArtComNum() == null) ? 0 : getArtComNum().hashCode());
        result = prime * result + ((getArtCommentId() == null) ? 0 : getArtCommentId().hashCode());
        result = prime * result + ((getArtContent() == null) ? 0 : getArtContent().hashCode());
        result = prime * result + ((getArtCreTime() == null) ? 0 : getArtCreTime().hashCode());
        result = prime * result + ((getArtHotNum() == null) ? 0 : getArtHotNum().hashCode());
        result = prime * result + ((getArtLikeNum() == null) ? 0 : getArtLikeNum().hashCode());
        result = prime * result + ((getArtTitle() == null) ? 0 : getArtTitle().hashCode());
        result = prime * result + ((getArtTypeId() == null) ? 0 : getArtTypeId().hashCode());
        result = prime * result + ((getArtUserId() == null) ? 0 : getArtUserId().hashCode());
        result = prime * result + ((getArtView() == null) ? 0 : getArtView().hashCode());
        result = prime * result + ((getArtImage() == null) ? 0 : getArtImage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", artId=").append(artId);
        sb.append(", artComNum=").append(artComNum);
        sb.append(", artCommentId=").append(artCommentId);
        sb.append(", artContent=").append(artContent);
        sb.append(", artCreTime=").append(artCreTime);
        sb.append(", artHotNum=").append(artHotNum);
        sb.append(", artLikeNum=").append(artLikeNum);
        sb.append(", artTitle=").append(artTitle);
        sb.append(", artTypeId=").append(artTypeId);
        sb.append(", artUserId=").append(artUserId);
        sb.append(", artView=").append(artView);
        sb.append(", artImageId=").append(artImage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}