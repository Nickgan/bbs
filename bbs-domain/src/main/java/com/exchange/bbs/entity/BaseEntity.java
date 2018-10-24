package com.exchange.bbs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 *
 * @author gan
 * @date 2018/10/24 下午12:41
 */
public abstract class BaseEntity implements Serializable {

    private String id;
    private Date updateTime;
    private Date createTime;

}
