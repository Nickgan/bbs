package com.exchange.bbs.post.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 发布帖子
 *
 * @author gan
 * @date 2018/11/12 9:42 PM
 */
@Data
public class AddPostReq {

    @NotBlank(message = "标题不能为空")
    private String title;

    @NotBlank(message = "内容不能为空")
    private String content;

    @NotBlank(message = "发帖人不能为空")
    private String authorId;

    @NotBlank(message = "所属版块Id不能为空")
    private String forumId;

    @NotBlank(message = "所属版块不能为空")
    private String forumName;

}
