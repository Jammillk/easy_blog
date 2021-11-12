package com.tanjiaming99.controller.admin;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.model.dto.AdminUserDTO;
import com.tanjiaming99.service.IAdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:39
 */
@RestController
@RequestMapping("/admin")
@Api(value = "后台用户操作相关接口")
public class AdminUserController {
    @Autowired
    private IAdminUserService adminUserService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    public AjaxRes<?> login(@RequestBody AdminUserDTO dto){
        return adminUserService.login(dto) ? AjaxRes.success("登录成功") : AjaxRes.fail("登录失败");
    }


}
