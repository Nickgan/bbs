package com.exchange.bbs.entity.bbslog;

import com.exchange.bbs.entity.BaseEntity;
import com.exchange.bbs.enums.BbsLogType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * BBS论坛用户关键日志数据库记录
 *
 * @author gan
 * @date 2018/10/24 下午1:44
 */

@Entity
@Table(name = "bbs_log")
@Data
@Accessors(chain = true)
public class BbsLog extends BaseEntity {

    private String ip;          //ip地址
    private String operation;   //操作
    private String description; //描述
    private String userId;      //用户id
    private String userName;    //用户名字

    @Enumerated(EnumType.STRING)
    private BbsLogType bbsLogType = BbsLogType.business;  //日志类型
}
