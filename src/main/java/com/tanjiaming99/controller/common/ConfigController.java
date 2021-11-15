package com.tanjiaming99.controller.common;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.common.model.Page;
import com.tanjiaming99.model.dto.BlogCategoryDTO;
import com.tanjiaming99.model.entity.Config;
import com.tanjiaming99.model.form.PageBlogForm;
import com.tanjiaming99.model.vo.BlogVO;
import com.tanjiaming99.service.IConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:40
 */
@RestController
@RequestMapping("/config")
@Api(value = "系统配置管理模块", tags = "系统配置管理模块")
public class ConfigController {
    @Autowired
    private IConfigService configService;

    @ApiOperation(value = "新增一条配置")
    @RequestMapping(method = RequestMethod.POST)
    public AjaxRes<?> create(@RequestBody Config config) {
        return configService.createConfig(config) ? AjaxRes.success("新增配置成功") : AjaxRes.fail("新增配置失败");
    }

    @ApiOperation(value = "修改一条配置")
    @RequestMapping(method = RequestMethod.PUT)
    public AjaxRes<?> update(@RequestBody Config config) {
        return configService.updateConfig(config) ? AjaxRes.success("修改配置成功") : AjaxRes.fail("修改配置失败");
    }

    @ApiOperation(value = "查询配置", notes = "分页查询配置")
    @RequestMapping(method = RequestMethod.GET)
    public AjaxRes<List<Config>> page() {
        return AjaxRes.success(configService.list());
    }


}
