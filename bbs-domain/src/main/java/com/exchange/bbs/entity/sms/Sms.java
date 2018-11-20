package com.exchange.bbs.entity.sms;

import com.exchange.bbs.entity.BaseEntity;
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
public class Sms extends BaseEntity {

    private String mobile;      //手机号
    private String message;     //短信内容
    private String source;      //来源(一般是系统名称)
    private String ip;          //ip地址
    private String signName;    //短信签名

}
