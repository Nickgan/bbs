package com.exchange.bbs.enums;

/**
 * 帖子发布状态
 *
 * @author gan
 * @date 2018/11/16 4:59 PM
 */
public enum PostStatus {

    SUCCESS("发布成功"),
    PROCESSING("发布中"),
    FAILED("发布失败");

    private String desc;

    PostStatus(String desc) {
        this.desc = desc;
    }
}
