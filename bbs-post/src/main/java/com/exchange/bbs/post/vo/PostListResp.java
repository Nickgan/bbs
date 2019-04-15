package com.exchange.bbs.post.vo;

import com.exchange.bbs.post.enums.PostStatus;
import lombok.Data;

import java.util.Date;

/**
 * 帖子列表
 * Created by ganbo on 2019/4/15.
 */
@Data
public class PostListResp {
    private boolean cream;      //是否精华
    private String title;       //帖子标题
    private String content;     //帖子内容
    private String authorId;    //发帖人Id
    private String authorName;  //发帖人名字
    private String forumId;     //所属版块
    private long clientRate;    //点击率
    private long replyCount;    //回复数量统计
    private Date lastReplyDate; //最后回复时间
    private PostStatus status;  //帖子状态

}
