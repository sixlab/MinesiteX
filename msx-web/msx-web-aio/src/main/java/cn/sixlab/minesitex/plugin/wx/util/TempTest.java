/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/3 13:48
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Date;

public class TempTest {
    public static void main(String[] args) {
        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");
        Element toUserName = xml.addElement("ToUserName");
        toUserName.addCDATA("ni<an>qini</an>yi");
        
        Element fromUserName = xml.addElement("FromUserName");
        fromUserName.addCDATA("n     i<an>123          456</an>y       i");
    
        Element createTime = xml.addElement("CreateTime");
        createTime.addText(String.valueOf(new Date().getTime() / 1000));
    
        Element msgType = xml.addElement("MsgType");
        msgType.addCDATA("text");
    
        Element content = xml.addElement("Content");
        content.addCDATA("ni<an>消息已收到</an>yi");
    
        System.out.println(document.asXML());
        System.out.println(document.getRootElement().element("FromUserName").getText());
        System.out.println(document.getRootElement().element("FromUserName").getTextTrim());
        System.out.println(document.getRootElement().element("FromUserName").getStringValue());
    }
}
