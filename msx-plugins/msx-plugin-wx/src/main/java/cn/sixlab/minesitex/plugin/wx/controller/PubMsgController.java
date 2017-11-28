/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
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
import cn.sixlab.minesitex.plugin.wx.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/wx/pub")
public class PubMsgController {
    
    @Autowired
    WxService wxService;
    
    @Autowired
    SecretService secretService;
    
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
}
