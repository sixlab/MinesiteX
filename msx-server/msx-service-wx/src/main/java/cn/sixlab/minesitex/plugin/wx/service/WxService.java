/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/3 13:25
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.service;

import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
import cn.sixlab.minesitex.data.wx.WxMsgRepo;
import cn.sixlab.minesitex.lib.base.util.InputStreamUtil;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import cn.sixlab.minesitex.lib.base.util.Sha1Utils;
import cn.sixlab.minesitex.plugin.wx.util.WxUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxService {
    private static Logger logger = LoggerFactory.getLogger(WxService.class);
    
    @Value("${wx.token}")
    private String wxToken;
    
    @Value("${wx.token}")
    private String wxkey;
    
    @Value("${wx.appId}")
    private String wxAppId;
    
    @Value("${wx.appSecret}")
    private String wxAppSecret;
    
    @Autowired
    WxMsgRepo msgRepo;
    
    @Autowired
    private StringRedisTemplate template;
    
    private static OkHttpClient defaultClient;
    
    static {
        defaultClient = new OkHttpClient();
    }
    
    public boolean checkToken(String signature, String timestamp, String nonce) {
        logger.info("验证微信签名");
        
        String[] tmpArr = new String[]{wxToken, timestamp, nonce};
        tmpArr = stringSort(tmpArr);
        
        String tmpStr = "";
        for (int i = 0; i < tmpArr.length; i++) {
            tmpStr += tmpArr[i];
        }
        tmpStr = Sha1Utils.shaHex(tmpStr);
        
        logger.info("tmpStrSHA=" + tmpStr);
        logger.info("signature=" + signature);
        
        if (StringUtils.startsWithIgnoreCase(tmpStr, signature)) {
            return true;
        } else {
            return false;
        }
    }
    
    private String[] stringSort(String[] s) {
        List<String> list = new ArrayList<>(s.length);
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        Collections.sort(list);
        return list.toArray(s);
    }
    
    public MsxWxMsg dealMsg(InputStream is) {
        String message = InputStreamUtil.readString(is);
    
        MsxWxMsg wxMsg = WxUtil.saveMsg(message, msgRepo);

        return wxMsg;
        //template.convertAndSend(MqTopic.WX_SAVE_MSG, me);
    }
    
    public String accessToken() {
        String key = "wxAccessToken";
        
        String wxAccessToken = template.opsForValue().get(key);
        
        if (StringUtils.isEmpty(wxAccessToken)) {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + wxAppId + "&secret=" + wxAppSecret;
            
            try {
                Request request = new Request.Builder().url(url).build();
                Response response = defaultClient.newCall(request).execute();
                String result = response.body().string();
                Map map = JsonUtl.toBean(result, Map.class);
                wxAccessToken = String.valueOf(map.get("access_token"));
                String expiresIn = String.valueOf(map.get("expires_in"));
                long expires = Long.parseLong(expiresIn);
                
                template.opsForValue().set(key, wxAccessToken, expires - 1200);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wxAccessToken;
    }
    
    /**
     * 给微信用户发送客服消息-文本类型
     *
     * @param accessToken token
     * @param openId      用户 OpenId
     * @param message     文本消息
     */
    public void sendCustomTextMsg(String openId, String message) {
        logger.info("发送微信消息to：" + openId);
        String accessToken = accessToken();
        
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("touser", openId);
        msgMap.put("msgtype", "text");
        
        Map<String, String> content = new HashMap<>();
        content.put("content", message);
        msgMap.put("text", content);
        
        String json = JsonUtl.toJson(msgMap);
        
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = defaultClient.newCall(request).execute();
            
            System.out.println("微信推送信息返回code：" + response.code());
            System.out.println("微信推送信息返回resp：" + response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
