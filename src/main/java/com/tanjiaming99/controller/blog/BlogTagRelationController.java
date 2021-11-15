package com.tanjiaming99.controller.blog;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.model.dto.BlogTagDTO;
import com.tanjiaming99.service.IBlogTagRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@RestController
@RequestMapping("/blog-tag-relation")
@Api(value = "博文中的标签操作", tags = "博文标签管理模块")
public class BlogTagRelationController {

    @Autowired
    private IBlogTagRelationService blogTagRelationService;

    @ApiOperation(value = "在博文中新增标签")
    @RequestMapping(method = RequestMethod.POST)
    public AjaxRes<?> createTagFromBlog(@RequestBody BlogTagDTO dto){
        return blogTagRelationService.createTagFromBlog(dto) ? AjaxRes.success("新增标签成功") : AjaxRes.fail("新增标签失败");
    }

    @ApiOperation(value = "修改博文中的标签")
    @RequestMapping(method = RequestMethod.PUT)
    public AjaxRes<?> updateTagForBlog(@RequestBody BlogTagDTO dto){
        return blogTagRelationService.updateTagForBlog(dto) ? AjaxRes.success("修改标签成功") : AjaxRes.fail("修改标签失败");

    }
}
