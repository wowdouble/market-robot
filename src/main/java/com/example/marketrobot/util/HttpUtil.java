package com.example.marketrobot.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class HttpUtil {
    private static final int DEFAULT_TIMEOUT = 50000;
    private static int timeout = DEFAULT_TIMEOUT;
    private static int maxConnTotal = 900;   //最大不要超过1000
    private static int maxConnPerRoute = 200;//实际的单个连接池大小，
    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);
    /**
     * post请求
     * @param url
     * @param data
     * @return
     */
    public static String doPost(String url, ArrayList<BasicNameValuePair> data) {
        HttpResponse response = null;
        try {
            //UrlEncodedFormEntity这个类是用来把输入数据编码成合适的内容
            //两个键值对，被UrlEncodedFormEntity实例编码后变为如下内容：param1=value1¶m2=value2
            //首先将参数设置为utf-8的形式
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(data,
                    HTTP.UTF_8);
            String result = "";
            HttpPost post = new HttpPost(url);//post方式
            RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(timeout)
                    .setConnectTimeout(timeout).setSocketTimeout(timeout).build();

            post.setConfig(config);
            post.setEntity(entity);//带上参数
            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(config)
                    .setMaxConnTotal(maxConnTotal)
                    .setMaxConnPerRoute(maxConnPerRoute).build();
            response = client.execute(post);//响应结果
            if (response.getStatusLine().getStatusCode() == 200) {
                //把结果取出来是一个STRING类型的
                result = EntityUtils.toString(response.getEntity());
                if (log.isDebugEnabled()) {
                    log.debug("doPost to {} response: {}", url, result);
                }
            } else {
                log.warn("doPost to {} response statusCode: {}, payload: {}", url, response.getStatusLine().getStatusCode(),
                        EntityUtils.toString(response.getEntity()));
            }

            return result;
        } catch (ConnectTimeoutException e) {
            log.error("doPost to {} raise ConnectTimeoutException, {}", url, e.getMessage());
        } catch (HttpHostConnectException e) {
            log.error("doPost to {} raise HttpHostConnectException, {}", url, e.getMessage());
        } catch (Exception e) {
            log.error("doPost to {} raise exception ,{}", url, e.getMessage());
        } finally {
            try {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                }
            } catch (IOException e) {
                log.error("doPost to {} raise final exception ,{}", url, e.getMessage());
            }
        }
        return null;
    }


    /**
     * 通过get来提交数据，带参数的方法
     *
     * @param url 请求地址
     * @param params 参数
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        String str = null;
        try {
            if (params != null && params.size() > 0) {
                int x = 1;
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if(x==1){
                        url = url + "?";
                    }else {
                        url = url + "&";
                    }
                    url+=entry.getKey()+"="+entry.getValue();
                    x++;
                }
            }
            HttpClient client = new HttpClient();
            System.out.println("url:::"+url);
            GetMethod method = new GetMethod(url);
//设定请求头的样式
            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            int code = client.executeMethod(method);
            if (code >= 200 && code < 300) {
                InputStream in = method.getResponseBodyAsStream();
                str = IOUtils.toString(in);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }


}
