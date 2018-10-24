package com.exchange.bbs.entity.reply;

import com.exchange.bbs.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 帖子留言和回复
 *
 * @author gan
 * @date 2018/10/24 下午1:22
 */

@Entity
@Table(name = "bbs_reply")
@Data
public class Reply extends BaseEntity {

    private String parentId;   //上一级帖子
    private String userId;     //回复用户
    private String postId;     //回复帖子
    private String content;    //回帖内容

}
