/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/2 10:44
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.base.gateway.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTParam {
    
    @Value("${msx.jwt.header}")
    private String jwtHeader;
    
    @Value("${msx.jwt.secret}")
    private String jwtSecret;
    
    @Value("${msx.jwt.expiration}")
    private int jwtExpiration;
    
    @Value("${msx.jwt.tokenHead}")
    private String jwtTokenHead;
    
    public String getJwtHeader() {
        return jwtHeader;
    }
    
    public void setJwtHeader(String jwtHeader) {
        this.jwtHeader = jwtHeader;
    }
    
    public String getJwtSecret() {
        return jwtSecret;
    }
    
    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }
    
    public int getJwtExpiration() {
        return jwtExpiration;
    }
    
    public void setJwtExpiration(int jwtExpiration) {
        this.jwtExpiration = jwtExpiration;
    }
    
    public String getJwtTokenHead() {
        return jwtTokenHead;
    }
    
    public void setJwtTokenHead(String jwtTokenHead) {
        this.jwtTokenHead = jwtTokenHead;
    }
}
