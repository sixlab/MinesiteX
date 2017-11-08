/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/27 14:07
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.controller;

import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
import cn.sixlab.minesitex.lib.base.BaseController;
import cn.sixlab.minesitex.plugin.wx.service.WxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@RestController
@RequestMapping("/wx/pub")
public class PubController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(PubController.class);
    
    @Autowired
    private WxService wxService;
    
    @RequestMapping("/push")
    public String push(HttpServletRequest request, HttpServletResponse response,
            String signature, String timestamp, String nonce, String echostr) throws IOException {
        logger.info("微信来消息了。。。");
    
        // 验签失败返回
        if (!wxService.checkToken(signature, timestamp, nonce)) {
            logger.info("验签失败");
            return "fail";
        }
    
        // 如果 echostr
        if (!StringUtils.isEmpty(echostr)) {
            return echostr;
        }
    
        //如果不是 echostr
        InputStream inputStream = request.getInputStream();
    
        MsxWxMsg wxMsg = wxService.dealMsg(inputStream);
    
    
        String fromUserName = wxMsg.getFromUserName();
        String msgType = wxMsg.getMsgType();
    
        String msg = "";
        if ("event".equals(msgType)) {
            String event = wxMsg.getTitle();
            if ("subscribe".equals(event)) {
                msg = "<xml>" +
                        "<ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>" +
                        "<FromUserName><![CDATA[sixlab]]></FromUserName>" +
                        "<CreateTime>" + String.valueOf(new Date().getTime() / 1000) + "</CreateTime>" +
                        "<MsgType><![CDATA[text]]></MsgType>" +
                        "<Content><![CDATA[感谢您的关注，更多功能敬请期待，现在您可以访问 sixlab.cn 发现更多精彩。]]></Content>" +
                        "</xml>";
            }
        } else {
            msg = "<xml>" +
                    "<ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>" +
                    "<FromUserName><![CDATA[sixlab]]></FromUserName>" +
                    "<CreateTime>" + String.valueOf(new Date().getTime() / 1000) + "</CreateTime>" +
                    "<MsgType><![CDATA[text]]></MsgType>" +
                    "<Content><![CDATA[消息已收到，更多功能敬请期待。]]></Content>" +
                    "</xml>";
        }
    
        return msg;
    }
    
    @RequestMapping("/redis")
    public String push(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        wxService.sendCustomTextMsg("oWRNos0xq0D8oZEQGx_pTPvGhXY","试一下");
        
        return "";
    }
}
