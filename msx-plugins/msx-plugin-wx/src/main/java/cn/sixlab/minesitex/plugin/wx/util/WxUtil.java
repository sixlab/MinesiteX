/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/4 01:09
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.util;

import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
import cn.sixlab.minesitex.data.wx.WxMsgRepo;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.springframework.util.StringUtils;

import java.util.Date;

public class WxUtil {
    
    public static MsxWxMsg saveMsg(String message, WxMsgRepo msgRepo){
        MsxWxMsg wxMsg = null;
    
        try {
            Document document = DocumentHelper.parseText(message);
        
            String msgType = document.getRootElement().element("MsgType").getText();
        
            String toUserName = document.getRootElement().element("ToUserName").getText();
            String fromUserName = document.getRootElement().element("FromUserName").getText();
            String createTime = document.getRootElement().element("CreateTime").getText();
        
            String msgId;
        
            if ("event".equals(msgType)) {
                msgId = fromUserName + " " + createTime;
            } else {
                msgId = document.getRootElement().element("MsgId").getText();
            }
        
            if (StringUtils.hasLength(msgId)) {
                wxMsg = msgRepo.findByMsgId(msgId);
    
                if (null == wxMsg) {
                    wxMsg = new MsxWxMsg();
                    wxMsg.setMsgId(msgId);
                
                    wxMsg.setToUserName(toUserName);
                    wxMsg.setFromUserName(fromUserName);
                    wxMsg.setCreateTime(createTime);
                
                    wxMsg.setMsgType(msgType);
                
                
                    // location - Scale
                    // link     - Title
                    // event    - Event
                    String title = null;
                
                    // voice    - Recognition
                    // location - Label
                    // link     - Description
                    // text     - Content
                    // event    - EventKey
                    String content = null;
                
                    // image      - MediaId
                    // voice      - MediaId
                    // video      - MediaId
                    // shortvideo - MediaId
                    // event      - Ticket
                    String mediaId = null;
                
                    // video      - ThumbMediaId
                    // shortvideo - ThumbMediaId
                    String thumbMediaId = null;
                
                    // image      - PicUrl
                    // shortvideo - ThumbMediaId
                    String url = null;
                
                    // voice      - Format
                    String format = null;
                
                    // location   - Location_X
                    // event      - Latitude
                    String locationX = null;
                    // location   - Location_Y
                    // event      - Longitude
                    String locationY = null;
                    // location   - Scale
                    // event      - Precision
                    String scale = null;
                
                    switch (msgType) {
                        case "text":
                            // 文本消息 text
                            content = document.getRootElement().element("Content").getText();
                        
                            break;
                        case "image":
                            // 图片消息 image
                            mediaId = document.getRootElement().element("MediaId").getText();
                            url = document.getRootElement().element("PicUrl").getText();
                        
                        
                            break;
                        case "voice":
                            // 语音消息 voice
                            mediaId = document.getRootElement().element("MediaId").getText();
                            content = document.getRootElement().element("Recognition").getText();
                            format = document.getRootElement().element("Format").getText();
                        
                            break;
                        case "video":
                            // 视频消息 video
                            mediaId = document.getRootElement().element("MediaId").getText();
                            thumbMediaId = document.getRootElement().element("ThumbMediaId").getText();
                        
                        
                            break;
                        case "shortvideo":
                            // 小视频消息 shortvideo
                            mediaId = document.getRootElement().element("MediaId").getText();
                            thumbMediaId = document.getRootElement().element("ThumbMediaId").getText();
                        
                            break;
                        case "location":
                            // 地理位置消息 location
                            locationX = document.getRootElement().element("Location_X").getText();
                            locationY = document.getRootElement().element("Location_Y").getText();
                            scale = document.getRootElement().element("Scale").getText();
                            content = document.getRootElement().element("Label").getText();
                        
                            break;
                        case "link":
                            // 链接消息 link
                            title = document.getRootElement().element("Title").getText();
                            content = document.getRootElement().element("Description").getText();
                            url = document.getRootElement().element("Url").getText();
                        
                            break;
                        case "event":
                            // 接收事件推送 event
                            title = document.getRootElement().element("Event").getText();
                            content = document.getRootElement().element("EventKey").getText();
                            mediaId = document.getRootElement().element("Ticket").getText();
                            locationX = document.getRootElement().element("Latitude").getText();
                            locationY = document.getRootElement().element("Longitude").getText();
                            scale = document.getRootElement().element("Precision").getText();
                        
                            break;
                    }
                
                    wxMsg.setTitle(title);
                    wxMsg.setContent(content);
                    wxMsg.setMediaId(mediaId);
                    wxMsg.setThumbMediaId(thumbMediaId);
                    wxMsg.setUrl(url);
                    wxMsg.setFormat(format);
                    wxMsg.setLocationX(locationX);
                    wxMsg.setLocationY(locationY);
                    wxMsg.setScale(scale);
                    wxMsg.setInsertTime(new Date());
                
                    msgRepo.saveAndFlush(wxMsg);
                }else{
                    wxMsg = null;
                }
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return wxMsg;
    }
}
