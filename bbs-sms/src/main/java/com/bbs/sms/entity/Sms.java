package com.bbs.sms.entity;

import com.exchange.bbs.core.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 短信消息
 *
 * @author gan
 * @date 2018/11/20 12:33 PM
 */
@Entity
@Table(name = "common_sms")
@Data
@Builder
public class Sms extends BaseEntity {

    private String mobile;      //手机号
    private String source;      //来源(一般是系统名称)
    private String ip;          //ip地址
    private String signName;    //短信签名
    private String params;      //短信参数

}
