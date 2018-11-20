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

    private String phone;       //手机号

    private String content;     //短信内容

}
