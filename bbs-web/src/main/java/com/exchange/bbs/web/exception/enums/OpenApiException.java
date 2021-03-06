package com.exchange.bbs.web.exception.enums;

import lombok.Getter;

/**
 * 系统异常枚举
 *
 * @author gan
 * @date 2018/10/24 下午12:49
 */

@Getter
public enum OpenApiException {


    /**
     * ================================
     * 全局异常
     * ================================
     */

    SYSTEM_FAILURE("9999", "系统错误"),
    PARAM_ERROR("10001", "参数校验失败"),
    FORUM_CATEGORY_NOT_FOUNT("10002", "版块分类不存在");

    private String code;
    private String message;

    OpenApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
