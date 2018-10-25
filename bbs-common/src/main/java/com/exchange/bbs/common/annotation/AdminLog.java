package com.exchange.bbs.common.annotation;

import java.lang.annotation.*;

/**
 * 后台管理系统日志注解
 *
 * @author gan
 * @date 2018/10/24 下午1:40
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdminLog {

}
