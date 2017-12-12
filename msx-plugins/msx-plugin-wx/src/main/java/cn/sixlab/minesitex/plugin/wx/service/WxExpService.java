/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/12 16:28
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.service;

import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
import cn.sixlab.minesitex.data.wx.WxMsgRepo;
import cn.sixlab.minesitex.lib.base.util.HttpUtil;
import cn.sixlab.minesitex.lib.base.util.InputStreamUtil;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import cn.sixlab.minesitex.plugin.wx.business.WxBusiness;
import cn.sixlab.minesitex.plugin.wx.util.MsxWxExpVal;
import cn.sixlab.minesitex.plugin.wx.util.WxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxExpService {
    private static Logger logger = LoggerFactory.getLogger(WxService.class);
    
    @Autowired
    MsxWxExpVal wxVal;
    
    @Autowired
    WxMsgRepo msgRepo;
    
    @Autowired
    private WxBusiness wxBusiness;
    
    public boolean checkToken(String signature, String timestamp, String nonce) {
        logger.info("验证微信签名-exp");
    
        return wxBusiness.checkToken(signature, timestamp, nonce, wxVal.getWxToken());
    }
    
    public MsxWxMsg dealMsg(InputStream is) {
        String message = InputStreamUtil.readString(is);
        
        MsxWxMsg wxMsg = WxUtil.saveMsg(message, msgRepo);
        
        //template.convertAndSend(MqTopic.WX_SAVE_MSG, me);
        return wxMsg;
    }
    
    /**
     * 给微信用户发送客服消息-文本类型
     *
     * @param openId  用户 OpenId
     * @param message 文本消息
     */
    public void sendCustomTextMsg(String openId, String message) {
        logger.info("发送微信消息to：" + openId);
        
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("touser", openId);
        msgMap.put("msgtype", "text");
        
        Map<String, String> content = new HashMap<>();
        content.put("content", message);
        msgMap.put("text", content);
        
        String json = JsonUtl.toJson(msgMap);
        
        String accessToken = wxBusiness.accessToken(wxVal.getWxAppId(), wxVal.getWxAppSecret());
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
        
        HttpUtil.postJson(url, json);
    }
}
