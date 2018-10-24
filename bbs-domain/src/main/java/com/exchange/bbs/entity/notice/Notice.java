package com.exchange.bbs.entity.notice;

import com.exchange.bbs.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 论坛公告
 *
 * @author gan
 * @date 2018/10/24 下午1:30
 */
@Entity
@Table(name = "bbs_notice")
@Data
public class Notice extends BaseEntity {

    private String title;   //标题
    private String content; //内容
}
