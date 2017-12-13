/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/14 14:34
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.controller;

import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import cn.sixlab.minesitex.lib.base.util.SecretService;
import cn.sixlab.minesitex.lib.redis.CacheManage;
import cn.sixlab.minesitex.plugin.wx.business.WxBusiness;
import cn.sixlab.minesitex.plugin.wx.service.WxService;
import cn.sixlab.minesitex.plugin.wx.util.MsxWxExpVal;
import cn.sixlab.minesitex.plugin.wx.util.WxMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wx/pub")
public class PubMsgController {
    private static Logger logger = LoggerFactory.getLogger(PubMsgController.class);
    
    @Autowired
    WxService wxService;
    
    @Autowired
    SecretService secretService;
    
    @Autowired
    private MsxWxExpVal wxVal;
    
    @Autowired
    private WxBusiness wxBusiness;
    
    @Autowired
    private CacheManage cacheManage;
    
    @RequestMapping("/msg/{strId}")
    public String msg(@PathVariable String strId, Model model) throws Exception {
        Integer id = secretService.decryptInt(strId);
        
        ModelJson<MsxWxMsg> json = wxService.fetchMsg(id);
        MsxWxMsg wxMsg = json.getData();
        model.addAttribute("wxMsg", wxMsg);
        model.addAttribute("strId", strId);
        
        return "wx/pub/msg/msg";
    }
    
    @RequestMapping("/msgs/{strId}")
    public String msgs(@PathVariable String strId, Model model) throws Exception {
        Integer id = secretService.decryptInt(strId);
        
        ModelJson<List<MsxWxMsg>> json = wxService.fetchMsgs(id);
        
        List<MsxWxMsg> msgList = json.getData();
        if (!CollectionUtils.isEmpty(msgList)) {
            for (MsxWxMsg wxMsg : msgList) {
                wxMsg.setToUserName(secretService.encrypt(wxMsg.getId()));
            }
        }
        model.addAttribute("msgList", msgList);
        
        return "wx/pub/msg/msgs";
    }
    
    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        logger.info("testSendTpl。。。");
        
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
        
        return "";
    }
    
    @ResponseBody
    @RequestMapping("/get")
    public String get() {
        logger.info("get。。。");
        
        return "<"+cacheManage.get(wxVal.getWxAppId())+">";
    }
    
    @ResponseBody
    @RequestMapping("/clear")
    public String clear() {
        logger.info("clear。。。");
    
        cacheManage.del(wxVal.getWxAppId());
        
        return "ok";
    }
}
