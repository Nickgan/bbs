package com.exchange.common.exception.enums;

/**
 * 系统异常枚举
 *
 * @author gan
 * @date 2018/10/24 下午12:49
 */
public enum OpenApiException {


    /**
     * ================================
     * 全局异常
     * ================================
     */

    SYSTEM_FAILURE("9999", "系统错误"),

    ;

    private String code;
    private String message;

    OpenApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
