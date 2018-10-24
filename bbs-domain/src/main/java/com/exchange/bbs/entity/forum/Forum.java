package com.exchange.bbs.entity.forum;

import com.exchange.bbs.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 论坛(主题)
 *
 * @author gan
 * @date 2018/10/24 上午10:41
 */

@Entity
@Table(name = "bbs_forum")
@Data
@Accessors(chain = true)
public class Forum extends BaseEntity {

    private String name;        //版块名称
    private String description; //版块描述
    private String author;      //版主
    private Long postNumber;    //帖子数

    private String mostNewPostAuthor;   //最新帖子名字
    private Date mostNewPostDate;       //最新发帖时间

}
