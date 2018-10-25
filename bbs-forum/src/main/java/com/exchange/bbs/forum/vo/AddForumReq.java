package com.exchange.bbs.forum.vo;

import lombok.Data;

import java.util.Date;

/**
 * 新增版块
 *
 * @author gan
 * @date 2018/10/25 下午6:35
 */

@Data
public class AddForumReq {

    private String categoryId;  //版块分类Id

    private String name;        //版块名称
    private String description; //版块描述
    private String author;      //版主
    private long postCount;     //帖子数
    private long replyCount;    //回帖数
    private String mostNewPostAuthor;   //最新帖子名字
    private Date mostNewPostDate;       //最新发帖时间

}
