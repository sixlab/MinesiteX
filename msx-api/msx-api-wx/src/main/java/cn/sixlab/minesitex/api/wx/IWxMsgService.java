/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/21 11:07
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.api.wx;

import cn.sixlab.minesitex.bean.wx.vo.SendMsgVo;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wx")
public interface IWxMsgService {
    
    @PostMapping(value = "/sendMsg")
    ModelJson<String> sendMsg(@RequestBody SendMsgVo vo);
    
}
