package com.exchange.bbs.user.entity;

import com.exchange.bbs.enums.Gender;
import com.exchange.bbs.enums.UserStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@NoArgsConstructor
@ToString(callSuper = true)
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User extends BaseEntity {

    private String username;    //用户名
    private String password;
    private String nickName;    //昵称
    private String email;       //邮箱

    @Enumerated(EnumType.STRING)
    private Gender gender;      //性别
    private Date birthday;      //生日
    private UserStatus status;  //用户状态
    private Date registerDate;  //注册时间
    private String ip;          //本次登陆ip
    private String lastIp;      //上次登陆ip

    private String headPhoto;   //头像
    private String job;         //工作职业
    private String hobby;       //爱好
    private String qq;          //QQ号
    private Long postCount;     //帖子数
    private String signature;   //签名


}
