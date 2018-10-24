package com.exchange.bbs.entity.user;

import com.exchange.bbs.entity.BaseEntity;
import com.exchange.bbs.enums.Gender;
import com.exchange.bbs.enums.UserStatus;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户
 *
 * @author gan
 * @date 2018/10/24 上午10:40
 */
@Entity
@Table(name = "bbs_user")
@Data
@Accessors(chain = true)
public class User extends BaseEntity {

    private String userName;    //用户名
    private String nickName;    //昵称
    private String email;       //邮箱

    @Enumerated(EnumType.STRING)
    private Gender gender;      //性别

    private UserStatus status;  //用户状态ß
    private Date registerDate;  //注册时间
    private String ip;          //本次登陆ip
    private String lastIp;      //上次登陆ip

}
