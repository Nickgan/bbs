package com.exchange.bbs.web.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;


//HttpClient4.2
public class HttpClientUtils {


    public static String get(String address) throws Exception {
        // 实例化连接对象
        HttpClient httpClient = new DefaultHttpClient();
        // 实例化一个get对象
        HttpGet httpGet = new HttpGet(address);
        // 设置额外请求参数:5秒钟连接超时
        // CONNECTION_TIMEOUT = "http.connection.timeout";
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        // 发出请求
        HttpResponse httpResponse = httpClient.execute(httpGet);
        // 判断响应码:404,200,500
        System.out.println("响应码:" + httpResponse.getStatusLine().getStatusCode());
        return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
    }

    public static String post(String address, Map<String, String> param) throws Exception {
        System.out.println("请求地址：" + address);
        // 实例化连接对象
        HttpClient httpClient = new DefaultHttpClient();
        // 实例化一个post对象
        HttpPost httpPost = new HttpPost(address);
        // 设置额外请求参数:5秒钟连接超时
        // CONNECTION_TIMEOUT = "http.connection.timeout";
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        // 把Map的参数变成List<NameValuePair>
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));

            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        // 传递表单的字符串的请求，不包含文件上传
        UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(parameters);
        // 添加post的请求
        httpPost.setEntity(encodedFormEntity);
        // 发出请求
        HttpResponse httpResponse = httpClient.execute(httpPost);
        // 判断响应码:404,200,500
        System.out.println("响应码:" + httpResponse.getStatusLine().getStatusCode());
        return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
    }

    public static String postJson(String address, String param) throws Exception {
        // 实例化连接对象
        HttpClient httpClient = new DefaultHttpClient();
        // 实例化一个post对象
        HttpPost httpPost = new HttpPost(address);
        // 设置额外请求参数:5秒钟连接超时
        // CONNECTION_TIMEOUT = "http.connection.timeout";
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        StringEntity stringEntity = new StringEntity(param, "UTF-8");
        // 添加post的请求
        httpPost.setEntity(stringEntity);
        // 发出请求
        HttpResponse httpResponse = httpClient.execute(httpPost);
        // 判断响应码:404,200,500
        System.out.println("响应码:" + httpResponse.getStatusLine().getStatusCode());
        return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
    }


}
