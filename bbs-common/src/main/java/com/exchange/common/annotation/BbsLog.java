package com.exchange.common.annotation;

import java.lang.annotation.*;

/**
 * bbs系统用户关键日志记录
 *
 * @author gan
 * @date 2018/10/24 下午1:41
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BbsLog {

}
