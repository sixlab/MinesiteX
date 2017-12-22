/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/21 11:11
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.wx.controller;

import cn.sixlab.minesitex.api.wx.IWxMsgService;
import cn.sixlab.minesitex.bean.wx.vo.SendMsgVo;
import cn.sixlab.minesitex.lib.base.BaseController;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import cn.sixlab.minesitex.plugin.wx.business.WxBusiness;
import cn.sixlab.minesitex.plugin.wx.util.MsxWxExpVal;
import cn.sixlab.minesitex.plugin.wx.util.WxMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxMsgApiController extends BaseController implements IWxMsgService {
    
    @Autowired
    private MsxWxExpVal wxVal;
    
    @Autowired
    private WxBusiness wxBusiness;
    
    @Override
    public ModelJson<String> sendMsg(@RequestBody SendMsgVo vo) {
    
        String accessToken = wxBusiness.accessToken(wxVal.getWxAppId(), wxVal.getWxAppSecret());
        String result = WxMsgUtil.sendTplMsg(accessToken, wxVal.getWxOpenId(), wxVal.getWxTpl(),
                vo.getUrl(), vo.getData());
    
        return new ModelJson<String>().setData(result);
    }
}
