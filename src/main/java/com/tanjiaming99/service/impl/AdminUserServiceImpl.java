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
import com.tanjiaming99.model.vo.LoginVO;
import com.tanjiaming99.service.IAdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanjiaming99.utils.JwtTokenUtil;
import com.tanjiaming99.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public LoginVO login(AdminUserDTO dto, HttpServletRequest request) {
        // 校验验证码
        String code = (String) request.getSession().getAttribute(KaptchaConfig.KAPTCHA_NAME);
        String verifyCode = dto.getVerifyCode();
        if (!Objects.equals(verifyCode, code)) {
            throw new ApplicationException(CommonErrorCode.ERROR_KAPTCHA_CODE, "验证码错误");
        }

        // 校验密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getLoginUserName());
        if (Objects.isNull(userDetails) /*|| !passwordEncoder.matches(dto.getLoginPassword(), userDetails.getPassword())*/) {
            throw new ApplicationException(CommonErrorCode.ERROR_PASSWORD, "密码错误");
        }

        // 更新security登录用户对象
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 生成token
        String token = jwtTokenUtil.generateToken(userDetails);

        // 组装返回值
        LoginVO result = LoginVO.builder()
                .token(token)
                .tokenHead(tokenHead).build();

        // 需要和数据库交互吗？
//        String passwordMd5 = MD5Util.MD5Encode(dto.getLoginPassword(), "UTF-8");
//        AdminUser adminUser = adminUserMapper.selectOne(new QueryWrapper<AdminUser>()
//                .eq("login_user_name", dto.getLoginUserName())
//                .eq("login_password", dto.getLoginPassword()));


        return result;
    }

    @Override
    public AdminUser getAdminUserByUsername(String username) {
        return adminUserMapper.selectOne(new QueryWrapper<AdminUser>()
                .eq("login_user_name", username));
    }

    @Override
    public Boolean updateMessage(AdminUser adminUser) {
        // spring security 可能还有一些操作？
        // ......
        return adminUserMapper.updateById(adminUser) > 0;
    }
}
