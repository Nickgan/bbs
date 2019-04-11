package com.exchange.bbs.admin.entity;

import com.exchange.bbs.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 后台管理角色
 *
 * @author gan
 * @date 2018/10/24 上午10:51
 */

@Entity
@Table(name = "admin_role")
@Data
public class AdminRole extends BaseEntity {

    private String name;

}
