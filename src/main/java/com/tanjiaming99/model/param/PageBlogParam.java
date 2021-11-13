package com.tanjiaming99.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/13 12:53
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "博客文章分页查询对象")
public class PageBlogParam {


    @ApiModelProperty("博客内容")
    private String blogContent;

    @ApiModelProperty("博客分类(冗余字段)")
    private String blogCategoryName;

    @ApiModelProperty("博客标签")
    private String blogTags;

}
