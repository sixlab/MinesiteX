///**
// * Copyright (c) 2017 Sixlab. All rights reserved.
// * <p>
// * License information see the LICENSE file in the project's root directory.
// * <p>
// * For more information, please see
// * https://sixlab.cn/
// *
// * @time: 2017/11/3 16:36
// * @author: Patrick <root@sixlab.cn>
// */
//package cn.sixlab.minesitex.plugin.wx.listener;
//
//import cn.sixlab.minesitex.lib.base.contants.MqTopic;
//import cn.sixlab.minesitex.lib.redis.MqContainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MqListenerContainer implements MqContainer {
//
//    @Autowired
//    private WxSaveMsgReceiver saveMsgReceiver;
//
//    //接口没权限，也是醉了
//    //@Autowired
//    //private WxSendMsgReceiver sendMsgReceiver;
//
//    @Override
//    public void addListener(RedisMessageListenerContainer container) {
//        container.addMessageListener(saveMsgReceiver, new PatternTopic(MqTopic.WX_SAVE_MSG));
//        //container.addMessageListener(sendMsgReceiver, new PatternTopic(MqTopic.WX_SEND_MSG));
//    }
//}
