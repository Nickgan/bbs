package com.exchange.bbs.web.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * SpringMVC RequestHolder工具类,获取当前请求线程的request和response对象
 *
 * @author ganbo
 * 2016年7月6日 下午6:50:09
 */
public class RequestHolder {

    /**
     * 获取当前线程request对象
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * 获取当前线程response对象
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        ServletWebRequest requestAttributes = (ServletWebRequest) RequestContextHolder.
                getRequestAttributes();
        return requestAttributes.getResponse();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 判断是否是ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        if (request.getHeader("accept") != null
                && request.getHeader("accept").indexOf("application/json") > -1) {
            return true;
        }
        if (request.getHeader("X-Requested-With") == null) {
            return false;
        }
        if (request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) {
            return true;
        }
        return false;
    }

}
