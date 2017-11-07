/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/1 23:18
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.base.zuul.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 *
 * http://blog.csdn.net/sxdtzhaoxinguo/article/details/77965226
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
    
    private JWTParam jwtParam;
    
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
    
    public JWTAuthenticationFilter setJwtParam(JWTParam jwtParam) {
        this.jwtParam = jwtParam;
        return this;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(jwtParam.getJwtHeader());
        
        if (token == null || !token.startsWith(jwtParam.getJwtTokenHead())) {
            chain.doFilter(request, response);
            return;
        }
        
        UsernamePasswordAuthenticationToken authentication = getAuthentication(token);
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
    
    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        // parse the token.
        String user = Jwts.parser()
                .setSigningKey(jwtParam.getJwtSecret())
                .parseClaimsJws(token.replace(jwtParam.getJwtTokenHead(), ""))
                .getBody()
                .getSubject();
    
        if (user != null) {
            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        }
        return null;
    }
}
