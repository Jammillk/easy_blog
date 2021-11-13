package com.tanjiaming99.advice;


import com.tanjiaming99.common.ajax.AjaxRes;
import com.tanjiaming99.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Controller统一异常处理
 *
 * @param <V>
 * @author llg
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ControllerExceptionAdvice<V> {

    /**
     * 自定义服务异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ApplicationException.class)
    public AjaxRes<String> serviceExceptionHandler(ApplicationException ex) {
        log.error(ex.getMessage(), ex);
        return AjaxRes.failMsg(ex.getMessage());
    }

    /**
     * 其他异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Object otherExceptionHandler(Exception ex) {
        log.error(ex.getMessage(), ex);
        if (ex instanceof BindException) {
            BindException e = (BindException) ex;
            List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
            ObjectError objectError = allErrors.get(0);
            String defaultMessage = objectError.getDefaultMessage();
            String objectName = objectError.getObjectName();
            if (objectName.equals("censorDto")) {
                HashMap<String, Object> errorMap = new HashMap<String, Object>();
                errorMap.put("code", 400);
                errorMap.put("message", defaultMessage);
                return errorMap;
            }
            return AjaxRes.failMsg(defaultMessage);
        }
        return AjaxRes.failMsg(ex.getMessage());
    }
}
