package com.exchange.bbs.entity.sms;

import com.exchange.bbs.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 短信发送对接系统名单
 *
 * @author gan
 * @date 2018/11/20 2:05 PM
 */
@Entity
@Table(name = "common_sms")
@Data
public class SourceList extends BaseEntity {

    private String source;  //来源(系统名字)

}
