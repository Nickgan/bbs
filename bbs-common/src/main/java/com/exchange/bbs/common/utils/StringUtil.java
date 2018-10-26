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
     * 按照时间生成编号(大安分局+当前时间)
     *
     * @return
     */
    public static String generateTableCode() {
        Date date = new Date();
        return "DAFJ" + DateUtils.formateDateyyyyMMddHHmmss(date);
    }

}
