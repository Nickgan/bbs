package com.exchange.bbs.entity;

/**
 * 后台管理员用户
 *
 * @author gan
 * @date 2018/10/24 上午10:54
 */
public class AdminUser extends BaseEntity {

    private String userName;    //用户名
    private String password;    //密码
    private String nickName;    //昵称
    private String ip;          //本次登陆ip
    private String lastIp;      //上次登陆ip


}
