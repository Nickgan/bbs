package com.exchange.bbs.forum.vo;

import lombok.Data;

import java.util.List;

/**
 * 版块列表返回
 *
 * @author gan
 * @date 2018/11/12 5:50 PM
 */

@Data
public class ForumListResp {

    private String categoryName;       //版块分类名称
    private List<ForumListDto> list;   //版块列表

}

