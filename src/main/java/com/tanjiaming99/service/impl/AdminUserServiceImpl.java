package com.tanjiaming99.service.impl;

import com.tanjiaming99.entity.AdminUser;
import com.tanjiaming99.mapper.AdminUserMapper;
import com.tanjiaming99.service.IAdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:39
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

}
