package com.tanjiaming99.exception;

import lombok.Getter;

/**
 * @author llg
 * @description 
 */
@Getter
public enum CommonErrorCode implements ErrorCode {

    ERROR_KAPTCHA_CODE("CommonError-0001", "错误的校验码"),
    ERROR_PASSWORD("CommonError-0002", "错误的密码"),
    ERROR_AUTHORIZATION("CommonError-0003", "未授权（权限不足）")
    ;

    private String code;

    private String description;

    CommonErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return String.format("Code:[%s], Description:[%s].", this.code,
                this.description);
    }

}
