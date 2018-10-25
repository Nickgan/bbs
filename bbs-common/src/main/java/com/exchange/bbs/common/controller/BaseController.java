package com.exchange.bbs.common.controller;

import com.exchange.bbs.common.dto.BaseResult;
import com.exchange.bbs.common.exception.BusinessException;
import com.exchange.bbs.common.exception.enums.OpenApiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 基础控制器
 *
 * @author gan
 * @date 2018/10/25 上午9:36
 */

@RestControllerAdvice
public class BaseController {

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public BaseResult errorHandler(Exception ex) {
        BaseResult result;
        if (ex instanceof BusinessException) {
            result = BaseResult.fail(((BusinessException) ex).getCode(), ex.getMessage());
        } else {
            result = BaseResult.fail(OpenApiException.SYSTEM_FAILURE);
        }
        return result;
    }


}
