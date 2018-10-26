package com.exchange.bbs.web.utils;

/**
 * 常量配置
 *
 * @author ganbo
 * 2016年6月21日 下午10:15:57
 */
public interface ConstantConfig {

    /**
     * session中的登陆用户
     */
    String USER_IN_SESSION = "user_in_session";

    /**
     * 当前登陆用户的菜单列表
     */
    String LOGIN_USER_MENUS = "login_user_menus";

    /**
     * 系统基本信息
     */
    String SYSCONFIG_INFO = "sysconfig_info";

    /**
     * 系统默认密码
     */
    String DEFAULT_PASSWORD = "123";

    /**
     * 当前在线用户统计application中的key
     */
    String ONLINE_USER_LIST = "onlineUserList";

    /**
     * 当前登陆用户的权限
     */
    String LOGIN_USER_PRIVILEGE = "Login_user_privilege";

}
