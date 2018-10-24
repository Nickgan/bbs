package com.exchange.bbs.entity;

import com.exchange.bbs.enums.Gender;

import java.util.Date;

/**
 * 用户
 *
 * @author gan
 * @date 2018/10/24 上午10:40
 */
public class User extends BaseEntity {

    private String userName;    //用户名
    private String nickName;    //昵称
    private String email;       //邮箱
    private Date birthDay;      //生日
    private Gender gender;      //性别
    private Date registerDate;  //注册时间
    private String ip;          //本次登陆ip
    private String lastIp;      //上次登陆ip

}
