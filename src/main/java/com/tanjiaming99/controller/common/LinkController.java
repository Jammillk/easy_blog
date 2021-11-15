package com.tanjiaming99.controller.common;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.entity.Link;
import com.tanjiaming99.service.ILinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/link")
@Api(value = "友链管理相关接口", tags = "友链管理模块")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @ApiOperation(value = "新增一条友链")
    @RequestMapping(method = RequestMethod.POST)
    public AjaxRes<?> create(@RequestBody @Valid Link link) {
        return linkService.save(link) ? AjaxRes.success("新增友链成功") : AjaxRes.fail("新增友链失败");
    }

    @ApiOperation(value = "删除一条友链")
    @RequestMapping(method = RequestMethod.DELETE)
    public AjaxRes<?> remove(@RequestBody Link link) {
        return linkService.removeById(link) ? AjaxRes.success("删除友链成功") : AjaxRes.fail("删除友链失败");
    }

    @ApiOperation(value = "修改一条友链")
    @RequestMapping(method = RequestMethod.PUT)
    public AjaxRes<?> update(@RequestBody  Link link) {
        return linkService.updateById(link) ? AjaxRes.success("修改友链成功") : AjaxRes.fail("修改友链失败");
    }

    @ApiOperation(value = "分页查询友链信息")
    @PostMapping("/page")
    public AjaxRes<Page<Link>> page(@RequestBody Page<Link> page) {
        return AjaxRes.success(linkService.page(page));
    }


}
