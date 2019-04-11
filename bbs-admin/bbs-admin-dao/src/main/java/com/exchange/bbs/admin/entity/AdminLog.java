package com.exchange.bbs.admin.entity;

import com.exchange.bbs.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 后台管理系统日志
 *
 * @author gan
 * @date 2018/10/24 下午1:43
 */
@Entity
@Table(name = "admin_log")
@Data
public class AdminLog extends BaseEntity {

    private String content;

}
