package com.tanjiaming99.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.tanjiaming99.config.KaptchaConfig;
import com.tanjiaming99.exception.ApplicationException;
import com.tanjiaming99.exception.CommonErrorCode;
import com.tanjiaming99.exception.ErrorCode;
import com.tanjiaming99.model.dto.AdminUserDTO;
import com.tanjiaming99.model.entity.AdminUser;
import com.tanjiaming99.mapper.AdminUserMapper;
import com.tanjiaming99.service.IAdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanjiaming99.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tanjiaming99
 * @since 2021-11-12 10:28:39
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public Boolean login(AdminUserDTO dto, HttpServletRequest request) {
        String code = (String) request.getSession().getAttribute(KaptchaConfig.KAPTCHA_NAME);
        String verifyCode = dto.getVerifyCode();
        if (!Objects.equals(verifyCode, code)){
            throw new ApplicationException(CommonErrorCode.ERROR_KAPTCHA_CODE, "验证码错误");
        }
        String passwordMd5 = MD5Util.MD5Encode(dto.getLoginPassword(), "UTF-8");
        return adminUserMapper.selectOne(new QueryWrapper<AdminUser>()
                .eq("login_user_name", dto.getLoginUserName())
                .eq("login_password", dto.getLoginPassword())) != null;
    }
}
