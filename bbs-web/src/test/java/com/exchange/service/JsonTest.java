package com.exchange.service;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author gan
 * @date 2018/11/8 6:05 PM
 */
public class JsonTest {

    public static void main(String[] args) {
        String json = "{\"id\":\"123123\"}";
        Req reqs = JSON.parseObject(json, Req.class);
        System.out.println("req=======>" + reqs);
        System.out.println(reqs.getId());
    }


}


class Req {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void getId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}