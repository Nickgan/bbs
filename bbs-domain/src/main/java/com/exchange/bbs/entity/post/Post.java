package com.exchange.bbs.entity.post;

import com.exchange.bbs.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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

    private String title;       //帖子标题
    private String content;     //帖子内容
    private String authorId;    //发帖人Id
    private String authorName;  //发帖人名字
    private String forumId;     //所属版块
    private Long clientRate;    //点击率
    private Long replyCount;    //回复数量统计
    private Date lastReplyDate; //最后回复时间

}
