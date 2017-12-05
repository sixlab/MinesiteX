///**
// * Copyright (c) 2017 Sixlab. All rights reserved.
// * <p>
// * License information see the LICENSE file in the project's root directory.
// * <p>
// * For more information, please see
// * https://sixlab.cn/
// *
// * @time: 2017/11/3 16:48
// * @author: Patrick <root@sixlab.cn>
// */
//package cn.sixlab.minesitex.plugin.wx.listener;
//
//import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
//import cn.sixlab.minesitex.data.wx.WxMsgRepo;
//import cn.sixlab.minesitex.lib.redis.MsxMessageListener;
//import cn.sixlab.minesitex.plugin.wx.util.WxUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class WxSaveMsgReceiver implements MsxMessageListener {
//
//    @Autowired
//    WxMsgRepo msgRepo;
//
//    @Autowired
//    private StringRedisTemplate template;
//
//    @Override
//    public void onMessage(String message) {
//        MsxWxMsg wxMsg = WxUtil.saveMsg(message, msgRepo);
//
//        // 接口没权限，搞不了
//        //if (wxMsg != null) {
//        //    template.convertAndSend(MqTopic.WX_SEND_MSG, wxMsg.getId());
//        //}
//    }
//
//}
