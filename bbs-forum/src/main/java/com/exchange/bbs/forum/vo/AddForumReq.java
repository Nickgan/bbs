package com.exchange.bbs.forum.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 新增版块
 *
 * @author gan
 * @date 2018/10/25 下午6:35
 */

@Data
public class AddForumReq {

    @NotBlank(message = "版块分类必传")
    private String categoryId;

    @NotBlank(message = "名称必传")
    private String name;

    @NotBlank(message = "描述必传")
    private String description;

    @NotBlank(message = "版主Id必传")
    private String userId;

    @NotBlank(message = "版主名必传")
    private String username;

}
