package com.exchange.bbs.entity.post;

import com.exchange.bbs.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 帖子
 *
 * @author gan
 * @date 2018/10/24 上午10:50
 */

@Entity
@Table(name = "bbs_post")
@Data
@Accessors(chain = true)
public class Post extends BaseEntity {

    private String title;   //帖子标题
    private String content; //帖子内容
    private String userId;  //发帖人
    private String forumId; //所属版块

}
