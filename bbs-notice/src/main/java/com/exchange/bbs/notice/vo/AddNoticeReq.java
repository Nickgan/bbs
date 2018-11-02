package com.exchange.bbs.notice.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 添加公告
 *
 * @author gan
 * @date 2018/11/2 下午3:56
 */

@Data
public class AddNoticeReq {

    @NotBlank(message = "标题不能为空")
    private String title;

    @NotBlank(message = "内容不能为空")
    private String content;

}
