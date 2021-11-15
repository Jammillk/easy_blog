package com.tanjiaming99.controller.blog;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.entity.BlogTag;
import com.tanjiaming99.service.IBlogTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@RestController
@RequestMapping("/blog-tag")
@Api(value = "博文标签管理", tags = "标签管理模块")
public class BlogTagController {
    @Autowired
    private IBlogTagService blogTagService;

    @ApiOperation(value = "新增一条标签")
    @RequestMapping(method = RequestMethod.POST)
    public AjaxRes<?> create(@RequestBody BlogTag blogTag) {
        return blogTagService.save(blogTag) ? AjaxRes.success("新增标签成功") : AjaxRes.fail("新增标签失败");
    }

    @ApiOperation(value = "查询所有标签")
    @GetMapping("/all")
    public AjaxRes<List<BlogTag>> queryAll() {
        return AjaxRes.success(blogTagService.list());
    }

    @ApiOperation(value = "分页查询标签")
    @PostMapping("/page")
    public AjaxRes<Page<BlogTag>> page(Page<BlogTag> page) {
        return AjaxRes.success(blogTagService.page(page));
    }

    @ApiOperation(value = "删除一条标签")
    @RequestMapping(method = RequestMethod.DELETE)
    public AjaxRes<?> delete(@RequestBody BlogTag blogTag) {
        return blogTagService.deleteTag(blogTag.getTagId())
                ? AjaxRes.success("删除标签成功") : AjaxRes.fail("删除标签失败");
    }

    @ApiOperation(value = "根据博文id查找标签")
    @GetMapping("/{blogId}")
    public AjaxRes<List<BlogTag>> findTagByBlogId(@PathVariable Integer blogId) {
        return AjaxRes.success(blogTagService.findTagByBlogId(blogId));
    }
}
