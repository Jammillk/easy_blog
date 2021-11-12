package com.tanjiaming99.controller;


import com.tanjiaming99.model.entity.Blog;
import com.tanjiaming99.service.IBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@RestController
@RequestMapping("/blog")
@Api(value = "博客文章相关的接口")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/hello")
    @ApiModelProperty
    public String hello() {
        return "hello";
    }

    @GetMapping("/{blogId}")
    @ApiOperation(value = "获取博客文章", notes = "根据id获取博客文章")
    public Blog getBlog(@PathVariable("blogId") Long blogId) {
        return blogService.getById(blogId);
    }


}
