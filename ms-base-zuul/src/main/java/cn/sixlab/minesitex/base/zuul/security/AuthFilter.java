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
package cn.sixlab.minesitex.base.zuul.security;

import cn.sixlab.minesitex.base.zuul.util.ZuulConstants;
import cn.sixlab.minesitex.lib.core.bean.ModelJson;
import cn.sixlab.minesitex.lib.core.constants.Err;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(AuthFilter.class);
    
    @Autowired
    private MsUser msUser;
    
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    
    @Override
    public int filterOrder() {
        return 0;
    }
    
    @Bean
    private AntPathMatcher pathMatcher() {
        return new AntPathMatcher();
    }
    
    @Override
    public boolean shouldFilter() {
        String uri = RequestContext.getCurrentContext().getRequest().getRequestURI();
        System.out.println("URL:" + uri);
        
        //if (ReqContextUtil.isContinue()) {
        //}
        
        return true;
    }
    
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        String accessToken = request.getHeader("accessSecret");
        
        boolean login = false;
        String uri = request.getRequestURI();
        if (StringUtils.isNotEmpty(accessToken)) {
            login = BCrypt.checkpw(msUser.toString(), accessToken);
        }
        
        if (login) {
            RequestContext.getCurrentContext().put("username", msUser.getUsername());
        } else if (!uri.contains("/pub/")) {
            String accessType = request.getHeader("accessType");
            String method = request.getMethod();
            
            HttpServletResponse response = ctx.getResponse();
            if (RequestMethod.GET.name().equals(method) && !"json".equals(accessType)) {
                try {
                    response.sendRedirect("/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                ModelJson json = new ModelJson().setErrorMessage(Err.Msg.NOT_LOGIN, Err.Code.NOT_LOGIN);
                
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                
                ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
                ctx.setResponseStatusCode(200);// 返回错误码
                ctx.setResponseBody(json.toString());// 返回错误内容
                ctx.set(ZuulConstants.FILTER_SKIP, true);
            }
        }
        
        return null;
    }
}
