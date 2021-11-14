package com.tanjiaming99.config.security;

import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.exception.CommonErrorCode;
import com.tanjiaming99.utils.JsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/14 14:17
 **/
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write(JsonUtil.obj2String(AjaxRes.fail(CommonErrorCode.ERROR_KAPTCHA_CODE, "未登录")));
        out.flush();
        out.close();
    }
}
