/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/9 18:06
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.text.base.zuul.util;

import cn.sixlab.mine.text.core.ModelJson;
import cn.sixlab.mine.text.core.ResponseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqContextUtil {
    
    public static HttpServletRequest getRequest() {
        return RequestContext.getCurrentContext().getRequest();
    }
    
    public static HttpServletResponse getResponse() {
        return RequestContext.getCurrentContext().getResponse();
    }
    
    public static void setError(ModelJson json) {
        ObjectMapper objectMapper = new ObjectMapper();
        String msg = "{}";
        try {
            msg = objectMapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        RequestContext ctx = RequestContext.getCurrentContext();
        
        ResponseUtil.setJsonType(ctx.getResponse());
    
        ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
        ctx.setResponseStatusCode(200);// 返回错误码
        ctx.setResponseBody(msg);// 返回错误内容
        ctx.set("continue", false);
    }
}
