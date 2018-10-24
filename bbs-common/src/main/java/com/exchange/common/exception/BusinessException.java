package com.exchange.common.exception;

/**
 * 业务异常
 *
 * @author gan
 * @date 2018/10/24 下午12:50
 */
public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    public BusinessException(String message) {
        super(message);
    }
}
