package com.exchange.bbs.common.exception;

import lombok.Data;

/**
 * 业务异常
 *
 * @author gan
 * @date 2018/10/24 下午12:50
 */

@Data
public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    public BusinessException(String message) {
        super(message);
    }
}
