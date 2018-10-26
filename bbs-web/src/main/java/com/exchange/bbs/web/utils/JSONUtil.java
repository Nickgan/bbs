package com.exchange.bbs.web.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON和Java对象转换工具类,使用FastJson实现
 *
 * @author ganbo
 * 2016年6月22日 上午11:36:06
 */
public class JSONUtil {

    /**
     * to java object transform Json String.
     */
    public static String objectTOJsonString(Object o) {
        return JSON.toJSONString(o);
    }

    /**
     * to Json string transform java object.
     */
    public static <T> T jsonStringToObject(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }

    /**
     * to json array transtorm List<T>
     */
    public static <T> List<T> jsonArrayToObjectList(String jsonArrayString, Class<T> clazz) {
        JSONArray jsonArray = JSON.parseArray(jsonArrayString);
        List<T> list = new ArrayList<T>();
        for (Object o : jsonArray) {
            JSON json = (JSON) o;
            list.add(JSON.toJavaObject(json, clazz));
        }
        return list;
    }

    /**
     * 将Json字符串解析为一个JSONObject对象,便于获取里面的普通属性和数组属性
     *
     * @param jsonStr
     * @return
     */
    public JSONObject parseStringToJSONObject(String jsonStr) {
        return JSONObject.parseObject(jsonStr);
    }

}
