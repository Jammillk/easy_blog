package com.tanjiaming99.controller.blog;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.model.dto.BlogCategoryDTO;
import com.tanjiaming99.service.IBlogCategoryService;
import com.tanjiaming99.service.IBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@RestController
@RequestMapping("/blog-category")
@Api(value = "博客分类管理模块", tags = "adfadsfdsf f  地")
public class BlogCategoryController {
    @Autowired
    private IBlogCategoryService blogCategoryService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增一个分类")
    public AjaxRes<?> create(@RequestBody BlogCategoryDTO dto){
        return blogCategoryService.createCategory(dto)
                ? AjaxRes.success("新增分类成功") : AjaxRes.fail("新增分类失败");
    }



}
