/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/12 17:44
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.schedule;

import cn.sixlab.minesitex.plugin.wx.business.WxBusiness;
import cn.sixlab.minesitex.plugin.wx.util.MsxWxExpVal;
import cn.sixlab.minesitex.plugin.wx.util.WxMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WxScheduleService {
    private static Logger logger = LoggerFactory.getLogger(WxScheduleService.class);
    
    @Autowired
    private MsxWxExpVal wxVal;
    
    @Autowired
    private WxBusiness wxBusiness;
    
    //@Scheduled(cron = "0 0 6 * * ?")
    //public void morning() {
    //    logger.info("good morning");
    //
    //    Map<String, Map<String, String>> data = new HashMap<>();
    //
    //    Map<String, String> first = new HashMap<>();
    //    first.put("value", "一天之计在于晨\n");
    //    data.put("first", first);
    //
    //    Map<String, String> keyword1 = new HashMap<>();
    //    keyword1.put("value", "早上好");
    //    data.put("keyword1", keyword1);
    //
    //    Map<String, String> keyword2 = new HashMap<>();
    //    keyword2.put("value", "一天之计在于晨");
    //    data.put("keyword2", keyword2);
    //
    //    Map<String, String> remark = new HashMap<>();
    //    remark.put("value", "一天之计在于晨");
    //    remark.put("color", "#FF4500");
    //    data.put("remark", remark);
    //
    //    String accessToken = wxBusiness.accessToken(wxVal.getWxAppId(), wxVal.getWxAppSecret());
    //    WxMsgUtil.sendTplMsg(accessToken, wxVal.getWxOpenId(), wxVal.getWxTpl(),
    //            "https://sixlab.cn", data);
    //
    //    logger.info("结束。");
    //}
    
    @Scheduled(cron = "0 0 20 * * ? ")
    public void tips() {
        logger.info("good tips");
    
        Map<String, Map<String, String>> data = new HashMap<>();
    
        Map<String, String> first = new HashMap<>();
        first.put("value", "梳理一天生活，让生活更有条理\n");
        data.put("first", first);
    
        Map<String, String> keyword1 = new HashMap<>();
        keyword1.put("value", "晚上好");
        data.put("keyword1", keyword1);
    
        Map<String, String> keyword2 = new HashMap<>();
        keyword2.put("value", "梳理一天生活，让生活更有条理");
        data.put("keyword2", keyword2);
    
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "梳理一天生活，让生活更有条理");
        remark.put("color", "#FF4500");
        data.put("remark", remark);
    
        String accessToken = wxBusiness.accessToken(wxVal.getWxAppId(), wxVal.getWxAppSecret());
        WxMsgUtil.sendTplMsg(accessToken, wxVal.getWxOpenId(), wxVal.getWxTpl(),
                "https://sixlab.cn", data);
    
        logger.info("结束。");
    }
    
    
    @Scheduled(cron = "0 0 22 * * ?")
    public void evening() {
        logger.info("good evening");
        
        Map<String, Map<String, String>> data = new HashMap<>();
        
        Map<String, String> first = new HashMap<>();
        first.put("value", "早睡早起，怡神爽气。\n");
        data.put("first", first);
        
        Map<String, String> keyword1 = new HashMap<>();
        keyword1.put("value", "晚安");
        data.put("keyword1", keyword1);
        
        Map<String, String> keyword2 = new HashMap<>();
        keyword2.put("value", "早睡早起，怡神爽气。");
        data.put("keyword2", keyword2);
        
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "早睡早起，怡神爽气。");
        remark.put("color", "#FF4500");
        data.put("remark", remark);
        
        String accessToken = wxBusiness.accessToken(wxVal.getWxAppId(), wxVal.getWxAppSecret());
        WxMsgUtil.sendTplMsg(accessToken, wxVal.getWxOpenId(), wxVal.getWxTpl(),
                "https://sixlab.cn", data);
        
        logger.info("结束。");
    }
}
