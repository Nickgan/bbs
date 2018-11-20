package com.exchange.bbs.common.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 字符串工具类
 *
 * @author gan
 * @since 2016年5月25日下午6:54:42
 */
public class StringUtil extends StringUtils {

    /**
     * 判断多个字符串是否全部不为空
     *
     * @param strs
     * @return 全部部位空返回true, 有一个以上为空就返回false
     */
    public static boolean stringsIsNotBlack(String... strs) {
        for (String str : strs) {
            if (org.apache.commons.lang.StringUtils.isBlank(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回一个32位的随机字符串
     *
     * @return
     */
    public static String get32RandomStr() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成4位数字验证码
     *
     * @return
     */
    public static String get4RandomNumber() {
        Integer code = (int)((Math.random() * (9999 - 1000 + 1)) + 1000);
        return code.toString();
    }


}
