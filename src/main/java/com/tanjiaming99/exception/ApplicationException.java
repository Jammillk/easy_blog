package com.tanjiaming99.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义异常
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class ApplicationException extends RuntimeException {

    public ApplicationException(ErrorCode errorCode, String errorMessage) {
        super(errorCode.getCode() + " - " + errorMessage);
    }

    public ApplicationException(ErrorCode errorCode, String errorMessage, Exception e) {
        super(errorCode.getCode() + " - " + errorMessage);
        log.error(e.getMessage(), e);
    }

    public static ApplicationException asApplicationException(CommonErrorCode errorCode, String message) {
        return new ApplicationException(errorCode, message);
    }

    public static ApplicationException asApplicationException(CommonErrorCode errorCode, String message, Exception e) {
        return new ApplicationException(errorCode, message);
    }

}
