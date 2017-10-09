/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/8 22:07
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.text.base.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    
    @Override
    public int filterOrder() {
        return 0;
    }
    
    @Override
    public boolean shouldFilter() {
        //RequestContext ctx = RequestContext.getCurrentContext();
        //HttpServletRequest request = ctx.getRequest();
        //String uri = request.getRequestURI();
        //
        //if(uri.contains("/pub/")){
        //    return false;
        //}
        return true;
    }
    
    @Override
    public Object run() {
        //RequestContext ctx = RequestContext.getCurrentContext();
        //HttpServletRequest request = ctx.getRequest();
        //String username = request.getParameter("username");
        //request.getMethod();
        //if (null != username && username.equals("chhliu")) {// 如果请求的参数不为空，且值为chhliu时，则通过
        //    ctx.setSendZuulResponse(true);// 对该请求进行路由
        //    ctx.setResponseStatusCode(200);
        //    ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
        //} else {
        //    ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
        //    ctx.setResponseStatusCode(401);// 返回错误码
        //    ctx.setResponseBody("{\"result\":\"username is not correct!\"}");// 返回错误内容
        //    ctx.set("isSuccess", false);
        //}
        //
        return null;
    }
}
