package com.tanjiaming99.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@TableName("tb_blog")
@ApiModel(value = "Blog对象", description = "")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客表主键id")
    @TableId(value = "blog_id", type = IdType.AUTO)
    private Long blogId;

    @ApiModelProperty("博客标题")
    @NotBlank(message = "博客标题不能为空")
    private String blogTitle;

    @ApiModelProperty("博客自定义路径url")
    private String blogSubUrl;

    @ApiModelProperty("博客封面图")
    private String blogCoverImage;

    @ApiModelProperty("博客内容")
    @NotBlank(message = "博客内容不能为空")
    private String blogContent;

    @ApiModelProperty("博客分类id")
    private Integer blogCategoryId;

    @ApiModelProperty("博客分类(冗余字段)")
    private String blogCategoryName;

    @ApiModelProperty("博客标签")
    private String blogTags;

    @ApiModelProperty("0-草稿 1-发布")
    private Integer blogStatus;

    @ApiModelProperty("阅读量")
    private Long blogViews;

    @ApiModelProperty("0-允许评论 1-不允许评论")
    private Integer enableComment;

    @ApiModelProperty("是否删除 0=否 1=是")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty("添加时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
    public String getBlogSubUrl() {
        return blogSubUrl;
    }

    public void setBlogSubUrl(String blogSubUrl) {
        this.blogSubUrl = blogSubUrl;
    }
    public String getBlogCoverImage() {
        return blogCoverImage;
    }

    public void setBlogCoverImage(String blogCoverImage) {
        this.blogCoverImage = blogCoverImage;
    }
    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }
    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }
    public String getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(String blogTags) {
        this.blogTags = blogTags;
    }
    public Integer getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(Integer blogStatus) {
        this.blogStatus = blogStatus;
    }
    public Long getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Long blogViews) {
        this.blogViews = blogViews;
    }
    public Integer getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(Integer enableComment) {
        this.enableComment = enableComment;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
            "blogId=" + blogId +
            ", blogTitle=" + blogTitle +
            ", blogSubUrl=" + blogSubUrl +
            ", blogCoverImage=" + blogCoverImage +
            ", blogContent=" + blogContent +
            ", blogCategoryId=" + blogCategoryId +
            ", blogCategoryName=" + blogCategoryName +
            ", blogTags=" + blogTags +
            ", blogStatus=" + blogStatus +
            ", blogViews=" + blogViews +
            ", enableComment=" + enableComment +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
