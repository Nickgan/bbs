package com.exchange.bbs.admin.entity;

import com.exchange.bbs.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 系统资源
 *
 * @author gan
 * @date 2018/10/24 上午10:56
 */

@Entity
@Table(name = "admin_resource")
@Data
public class AdminResource extends BaseEntity {

    private String name;

}
