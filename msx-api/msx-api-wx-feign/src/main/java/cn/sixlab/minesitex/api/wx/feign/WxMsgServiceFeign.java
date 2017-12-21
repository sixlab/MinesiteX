/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/21 11:08
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.api.wx.feign;

import cn.sixlab.minesitex.api.wx.IWxMsgService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("msx-service-wx")
public interface WxMsgServiceFeign extends IWxMsgService {
}
