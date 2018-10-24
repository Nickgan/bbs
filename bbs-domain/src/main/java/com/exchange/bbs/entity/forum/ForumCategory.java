package com.exchange.bbs.entity.forum;

import com.exchange.bbs.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 类目(版块forum分类)
 *
 * @author gan
 * @date 2018/10/24 上午10:53
 */
@Entity
@Table(name = "bbs_forum_category")
@Data
@Accessors(chain = true)
public class ForumCategory extends BaseEntity {

    private String name;         //版块分类名称
    private String description;  //版块分类描述

}
