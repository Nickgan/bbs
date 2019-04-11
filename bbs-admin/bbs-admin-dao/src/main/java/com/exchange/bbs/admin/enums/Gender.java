package com.exchange.bbs.admin.enums;

/**
 * 性别
 *
 * @author gan
 * @date 2018/10/24 下午12:46
 */
public enum Gender {

    MAN("1", "男"),
    WOMAN("2", "女"),
    OTHER("3", "其他"),
    ;

    private String code;
    private String desc;

    Gender(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
