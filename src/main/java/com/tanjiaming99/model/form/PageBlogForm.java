package com.tanjiaming99.model.form;

import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.param.PageBlogParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/13 12:54
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "博客文章分页查询对象")
public class PageBlogForm<T> {
    @ApiModelProperty(value = "分页参数", required = true)
    private Page<T> page;

    @ApiModelProperty(value = "博客文章分页查询参数")
    @Valid
    private PageBlogParam param;
}
