package com.exchange.bbs.web.vo;

import lombok.Data;

import java.util.Date;

/**
 * 版块列表
 *
 * @author gan
 * @date 2018/11/12 6:27 PM
 */
@Data
public class ForumListDto {
    private String name;        //版块名称
    private String description; //版块描述
    private String userId;      //版主ID
    private String username;    //版主
    private long postCount;     //帖子数
    private long replyCount;    //回帖数

    private Date mostNewPostDate;           //最新发帖时间
    private String mostNewPostAuthorId;     //最新发帖人id
    private String mostNewPostAuthorName;   //最新发帖人名字
}
