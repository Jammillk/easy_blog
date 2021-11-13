package com.tanjiaming99.model.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/13 13:24
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "博客文章分页查询返回对象")
public class BlogVO {

    @ApiModelProperty("博客标题")
    private String blogTitle;

    @ApiModelProperty("博客内容")
    private String blogContent;

    @ApiModelProperty("博客分类id")
    private Integer blogCategoryId;

    @ApiModelProperty("博客分类(冗余字段)")
    private String blogCategoryName;

    @ApiModelProperty("博客标签")
    private String blogTags;

    @ApiModelProperty("阅读量")
    private Long blogViews;


}
