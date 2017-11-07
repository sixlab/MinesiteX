///**
// * Copyright (c) 2017 Sixlab. All rights reserved.
// * <p>
// * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
// * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
// * <p>
// * For more information, please see
// * https://sixlab.cn/
// *
// * @time: 2017/11/3 23:06
// * @author: Patrick <root@sixlab.cn>
// */
//package cn.sixlab.minesitex.plugin.wx.listener;
//
//import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
//import cn.sixlab.minesitex.data.wx.WxMsgRepo;
//import cn.sixlab.minesitex.lib.redis.MsxMessageListener;
//import cn.sixlab.minesitex.plugin.wx.service.WxService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class WxSendMsgReceiver implements MsxMessageListener {
//
//    @Autowired
//    WxMsgRepo msgRepo;
//
//    @Autowired
//    WxService wxService;
//
//    @Override
//    public void onMessage(String message) {
//        Integer msgId = Integer.valueOf(message);
//
//        MsxWxMsg wxMsg = msgRepo.findOne(msgId);
//
//        String fromUserName = wxMsg.getFromUserName();
//        String msgType = wxMsg.getMsgType();
//
//        if("event".equals(msgType)){
//            String event = wxMsg.getTitle();
//            if("subscribe".equals(event)){
//                wxService.sendCustomTextMsg(fromUserName, "感谢您的关注，更多功能敬请期待，现在您可以访问 sixlab.cn 发现更多精彩。");
//            }
//        }else{
//            // 发送消息
//            wxService.sendCustomTextMsg(fromUserName, "收到你的消息了，更多功能敬请期待。");
//        }
//    }
//}
