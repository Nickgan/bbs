package com.exchange.bbs.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 *
 * @author gan
 * @date 2018/10/24 下午12:41
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "UPDATETIME")
    private Date updateTime;
    @Column(name = "CREATETIME")
    private Date createTime;

}
