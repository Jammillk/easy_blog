package com.tanjiaming99.controller;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.model.dto.BlogDTO;
import com.tanjiaming99.model.entity.Blog;
import com.tanjiaming99.service.IBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public AjaxRes<Blog> getBlog(@PathVariable("blogId") Long blogId) {
        return AjaxRes.success(blogService.getById(blogId));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增博客文章", notes = "新增一篇博客")
    public AjaxRes<?> create(@RequestBody BlogDTO dto){
        return blogService.createBlog(dto) ? AjaxRes.success("新建成功") : AjaxRes.fail("新建失败");
    }





}
