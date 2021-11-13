package com.tanjiaming99.exception;

/**
 * @author llg
 * @description 错误代码接口
 */
public interface ErrorCode {

    /**
     * 获取描述信息
     *
     * @return
     */
    String getDescription();

    /**
     * 错误编码
     *
     * @return
     */
    String getCode();
}
