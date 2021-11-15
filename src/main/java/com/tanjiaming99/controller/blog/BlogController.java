package com.tanjiaming99.controller.blog;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.dto.BlogDTO;
import com.tanjiaming99.model.entity.Blog;
import com.tanjiaming99.model.form.PageBlogForm;
import com.tanjiaming99.model.vo.BlogVO;
import com.tanjiaming99.service.IBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public AjaxRes<?> create(@RequestBody @Valid Blog blog) {
        return blogService.createBlog(blog) ? AjaxRes.success("新建成功") : AjaxRes.fail("新建失败");
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改博客文章", notes = "修改博客文章")
    public AjaxRes<?> update(@RequestBody  Blog blog) {
        return blogService.updateById(blog) ? AjaxRes.success("修改成功") : AjaxRes.fail("修改失败");
    }


    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除博客文章", notes = "删除博客文章")
    public AjaxRes<?> remove(@RequestBody BlogDTO dto) {
        return blogService.removeById(dto.getBlogId()) ? AjaxRes.success("删除成功") : AjaxRes.fail("删除失败");
    }


    @PostMapping("/page")
    @ApiOperation(value = "分页查询博客文章", notes = "分页查询博客文章")
    public AjaxRes<Page<BlogVO>> page(@RequestBody @Valid PageBlogForm<BlogVO> form) {
        return AjaxRes.success(blogService.queryPage(form.getPage(), form.getParam()));
    }


    @PostMapping("/status")
    @ApiOperation(value = "修改博客文章发布状态", notes = "修改博客文章发布状态")
    public AjaxRes<?> status(@RequestBody BlogDTO dto) {
        return blogService.update(new UpdateWrapper<Blog>().set("blog_status", dto.getBlogStatus()).eq("blog_id", dto.getBlogId()))
                    ? AjaxRes.success("修改成功") : AjaxRes.fail("修改失败");
    }

}
