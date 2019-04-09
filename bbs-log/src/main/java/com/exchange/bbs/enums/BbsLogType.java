package com.exchange.bbs.enums;

import lombok.AllArgsConstructor;

/**
 * bbs日志类型
 *
 * @author gan
 * @date 2018/10/24 下午9:27
 */
@AllArgsConstructor
public enum BbsLogType {

    Exception("异常日志"),
    business("业务日志"),;

    private String desc;
}
