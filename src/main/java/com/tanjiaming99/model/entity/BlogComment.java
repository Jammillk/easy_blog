package com.tanjiaming99.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@TableName("tb_blog_comment")
@ApiModel(value = "BlogComment对象", description = "")
public class BlogComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    @ApiModelProperty("关联的blog主键")
    private Long blogId;

    @ApiModelProperty("评论者名称")
    private String commentator;

    @ApiModelProperty("评论人的邮箱")
    private String email;

    @ApiModelProperty("网址")
    private String websiteUrl;

    @ApiModelProperty("评论内容")
    private String commentBody;

    @ApiModelProperty("评论提交时间")
    private LocalDateTime commentCreateTime;

    @ApiModelProperty("评论时的ip地址")
    private String commentatorIp;

    @ApiModelProperty("回复内容")
    private String replyBody;

    @ApiModelProperty("回复时间")
    private LocalDateTime replyCreateTime;

    @ApiModelProperty("是否审核通过 0-未审核 1-审核通过")
    private Integer commentStatus;

    @ApiModelProperty("是否删除 0-未删除 1-已删除")
    private Integer isDeleted;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
    public LocalDateTime getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(LocalDateTime commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }
    public String getCommentatorIp() {
        return commentatorIp;
    }

    public void setCommentatorIp(String commentatorIp) {
        this.commentatorIp = commentatorIp;
    }
    public String getReplyBody() {
        return replyBody;
    }

    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody;
    }
    public LocalDateTime getReplyCreateTime() {
        return replyCreateTime;
    }

    public void setReplyCreateTime(LocalDateTime replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }
    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "BlogComment{" +
            "commentId=" + commentId +
            ", blogId=" + blogId +
            ", commentator=" + commentator +
            ", email=" + email +
            ", websiteUrl=" + websiteUrl +
            ", commentBody=" + commentBody +
            ", commentCreateTime=" + commentCreateTime +
            ", commentatorIp=" + commentatorIp +
            ", replyBody=" + replyBody +
            ", replyCreateTime=" + replyCreateTime +
            ", commentStatus=" + commentStatus +
            ", isDeleted=" + isDeleted +
        "}";
    }
}
