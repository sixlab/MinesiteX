/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/12 16:59
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base.util;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    
    private static OkHttpClient defaultClient;
    
    static {
        defaultClient = new OkHttpClient();
    }
    
    public static OkHttpClient client() {
        return defaultClient;
    }
    
    public static String postJson(String url, String json) {
        String result = "{}";
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
            
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = defaultClient.newCall(request).execute();
            
            System.out.println("微信推送信息返回code：" + response.code());
            System.out.println("微信推送信息返回resp：" + response.body().string());
            result = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String reqJson(String url) {
        String result = "{}";
        
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = defaultClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
