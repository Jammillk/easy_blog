package com.tanjiaming99.controller.blog;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.dto.BlogCategoryDTO;
import com.tanjiaming99.model.entity.BlogCategory;
import com.tanjiaming99.service.IBlogCategoryService;
import com.tanjiaming99.service.IBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@RestController
@RequestMapping("/blog-category")
@Api(value = "博客分类管理模块", tags = "博文分类管理模块")
public class BlogCategoryController {
    @Autowired
    private IBlogCategoryService blogCategoryService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增一个分类")
    public AjaxRes<?> create(@RequestBody BlogCategoryDTO dto) {
        return blogCategoryService.createCategory(dto)
                ? AjaxRes.success("新增分类成功") : AjaxRes.fail("新增分类失败");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除一个分类")
    public AjaxRes<?> delete(@RequestBody BlogCategoryDTO dto) {
        return blogCategoryService.removeById(dto.getCategoryId())
                ? AjaxRes.success("删除分类成功") : AjaxRes.fail("删除分类失败");
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "修改一个分类")
    public AjaxRes<?> update(@RequestBody BlogCategoryDTO dto) {
        return blogCategoryService.update(new UpdateWrapper<BlogCategory>()
                .set("category_name", dto.getCategoryName())
                .eq("category_id", dto.getCategoryId()))
                ? AjaxRes.success("修改分类成功") : AjaxRes.fail("修改分类失败");
    }

    @PostMapping("/page")
    @ApiOperation(value = "分页查询分类项")
    public AjaxRes<Page<BlogCategory>> page(@RequestBody Page<BlogCategory> page) {
        return AjaxRes.success(blogCategoryService.page(page));
    }


}
