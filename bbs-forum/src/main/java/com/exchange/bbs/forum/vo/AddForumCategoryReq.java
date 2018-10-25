package com.exchange.bbs.forum.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 添加版块分类
 *
 * @author gan
 * @date 2018/10/25 下午4:53
 */
@Data
public class AddForumCategoryReq {

    @NotBlank(message = "版块分类名称不能为空")
    private String name;

    @NotBlank(message = "版块分类描述不能为空")
    private String description;

}
