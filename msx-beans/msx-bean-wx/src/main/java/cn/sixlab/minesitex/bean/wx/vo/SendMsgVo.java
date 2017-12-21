/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/21 11:23
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.bean.wx.vo;

import java.io.Serializable;
import java.util.Map;

public class SendMsgVo implements Serializable {
    private String url;
    private Map<String, Map<String, String>> data;
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Map<String, Map<String, String>> getData() {
        return data;
    }
    
    public void setData(
            Map<String, Map<String, String>> data) {
        this.data = data;
    }
}
