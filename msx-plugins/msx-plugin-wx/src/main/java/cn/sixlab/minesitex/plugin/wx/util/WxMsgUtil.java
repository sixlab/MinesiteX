/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/12 18:30
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.util;

import cn.sixlab.minesitex.lib.base.util.HttpUtil;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class WxMsgUtil {
    private static Logger logger = LoggerFactory.getLogger(WxMsgUtil.class);
    
    public static String sendTplMsg(String accessToken,
            String openId, String templateId, String link,
            Map<String, Map<String, String>> data) {
        
        Map<String, Object> map = new HashMap<>();
        map.put("touser", openId);
        map.put("template_id", templateId);
        map.put("url", link);
        map.put("data", data);
        
        String json = JsonUtl.toJson(map);
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;
        
        String content = HttpUtil.postJson(url, json);
        logger.info("微信推送消息返回：" + content);
        
        return content;
    }
}
