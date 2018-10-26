package com.exchange.bbs.web.exception;

import com.exchange.bbs.web.exception.enums.OpenApiException;
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
    private Object otherInfo;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String code, String message, Object otherInfo) {
        super(message);
        this.code = code;
        this.message = message;
        this.otherInfo = otherInfo;
    }

    public BusinessException(OpenApiException ex) {
        this.code = ex.getCode();
        this.message = ex.getMessage();
    }
}
