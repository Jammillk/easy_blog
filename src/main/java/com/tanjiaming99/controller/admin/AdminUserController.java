package com.tanjiaming99.controller.admin;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.model.dto.AdminUserDTO;
import com.tanjiaming99.model.entity.AdminUser;
import com.tanjiaming99.model.vo.LoginVO;
import com.tanjiaming99.service.IAdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
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
    public AjaxRes<LoginVO> login(@RequestBody @Valid AdminUserDTO dto, HttpServletRequest request) {
        return AjaxRes.success(adminUserService.login(dto, request));
    }

    /**
     * 以后可能再修改用户对象，以保存更多的信息。
     * @param principal
     * @return
     */
    @PostMapping("/info")
    @ApiOperation(value = "获取用户信息")
    public AjaxRes<AdminUser> info(Principal principal) {
        if (Objects.isNull(principal)) {
            return AjaxRes.fail(null, "获取失败");
        }
        String username = principal.getName();
        AdminUser adminUser = adminUserService.getAdminUserByUsername(username);
        adminUser.setLoginPassword(null);
        return AjaxRes.success(adminUser);
    }


    /**
     * 让前端把token丢掉就行了，不用后端处理
     *
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation(value = "退出登录接口")
    public AjaxRes<?> logout() {
        return AjaxRes.success("注销成功！");
    }

}
