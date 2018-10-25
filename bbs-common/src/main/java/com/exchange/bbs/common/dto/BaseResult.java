package com.exchange.bbs.common.dto;

import com.exchange.bbs.common.exception.enums.OpenApiException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本返回信息封装类
 *
 * @author gan
 * @date 2018/10/24 下午5:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult {

    private boolean success;
    private String code;
    private String message;
    private Object data;

    /**
     * 返回成功
     *
     * @param code
     * @param data
     * @return
     */
    public static BaseResult success(String code, Object data) {
        return new BaseResult(true, code, null, data);
    }

    /**
     * 返回失败
     *
     * @param code
     * @param message
     * @return
     */
    public static BaseResult fail(String code, String message) {
        return new BaseResult(false, code, message, null);
    }

    /**
     * 返回失败
     *
     * @param o
     * @return
     */
    public static BaseResult fail(OpenApiException o) {
        return fail(o.getCode(), o.getMessage());
    }
}
