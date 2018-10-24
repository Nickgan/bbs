package com.exchange.common.dto;

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
    private String message;
    private Object data;

    public BaseResult(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public static BaseResult success(Object data) {
        return new BaseResult(true, data);
    }
}
