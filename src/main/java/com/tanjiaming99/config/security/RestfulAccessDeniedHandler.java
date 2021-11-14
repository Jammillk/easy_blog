package com.tanjiaming99.config.security;

import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.exception.CommonErrorCode;
import com.tanjiaming99.utils.JsonUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author tanjiaming99.com
 * @Date 2021/11/14 14:22
 **/
@Component
public class RestfulAccessDeniedHandler  implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write(JsonUtil.obj2String(AjaxRes.fail(CommonErrorCode.ERROR_AUTHORIZATION, "权限不足")));
        out.flush();
        out.close();
    }
}
