package com.tanjiaming99.entity;

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
@TableName("tb_blog_tag_relation")
@ApiModel(value = "BlogTagRelation对象", description = "")
public class BlogTagRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("关系表id")
    @TableId(value = "relation_id", type = IdType.AUTO)
    private Long relationId;

    @ApiModelProperty("博客id")
    private Long blogId;

    @ApiModelProperty("标签id")
    private Integer tagId;

    @ApiModelProperty("添加时间")
    private LocalDateTime createTime;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }
    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogTagRelation{" +
            "relationId=" + relationId +
            ", blogId=" + blogId +
            ", tagId=" + tagId +
            ", createTime=" + createTime +
        "}";
    }
}
