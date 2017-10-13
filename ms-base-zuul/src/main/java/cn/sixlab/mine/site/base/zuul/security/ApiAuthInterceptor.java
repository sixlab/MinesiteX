/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/12 10:34
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.base.zuul.security;

import cn.sixlab.mine.site.lib.core.bean.ModelJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ApiAuthInterceptor implements HandlerInterceptor{
    
    @Autowired
    private MsUser msUser;
    
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(">>> 在请求处理之前进行调用（Controller方法调用之前）");
    
        String secret = httpServletRequest.getHeader("accessSecret");
        
        ModelJson json = new ModelJson();
        if (secret == null) {
            json.setErrorMessage("权限参数为空", 10000);
        }
    
        if (!BCrypt.checkpw(msUser.toString(), secret)) {
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
        
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(json.toString());
            writer.close();
        
            return false;
        }
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
            throws Exception {
        
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        
    }
}
