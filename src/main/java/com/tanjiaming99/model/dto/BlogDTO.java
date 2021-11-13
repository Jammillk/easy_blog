package com.tanjiaming99.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tanjiaming99
 * @version 1.0
 * @date 2021/11/12 17:26
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ApiModel(description = "博客文章请求参数")
public class BlogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客表主键id")
    private Long blogId;

    @ApiModelProperty("博客标题")
    private String blogTitle;

    @ApiModelProperty("博客封面图")
    private String blogCoverImage;

    @ApiModelProperty("博客内容")
    private String blogContent;

    @ApiModelProperty("博客分类id")
    private Integer blogCategoryId;

    @ApiModelProperty("博客分类(冗余字段)")
    private String blogCategoryName;

    @ApiModelProperty("博客标签")
    private String blogTags;

    @ApiModelProperty("0-草稿 1-发布")
    private Integer blogStatus;

    @ApiModelProperty("0-允许评论 1-不允许评论")
    private Integer enableComment;


}
