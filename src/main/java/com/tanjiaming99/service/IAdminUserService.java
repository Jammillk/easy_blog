package com.tanjiaming99.service;

import com.tanjiaming99.model.dto.AdminUserDTO;
import com.tanjiaming99.model.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:39
 */
public interface IAdminUserService extends IService<AdminUser> {

    Boolean login(AdminUserDTO dto, HttpServletRequest request);

}
