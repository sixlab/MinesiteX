/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/29 15:38
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex;

import cn.sixlab.minesitex.base.gateway.security.JWTParam;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import cn.sixlab.minesitex.lib.base.util.WebUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MsxController {
    
    @Autowired
    private JWTParam jwtParam;
    
    @ResponseBody
    @GetMapping("/login/refresh")
    public ModelJson<Map> refresh(HttpServletRequest request) {
        String token = WebUtil.readToken(request, jwtParam.getJwtHeader());
    
        String username = Jwts.parser()
                .setSigningKey(jwtParam.getJwtSecret())
                .parseClaimsJws(token.replace(jwtParam.getJwtTokenHead(), ""))
                .getBody()
                .getSubject();
        long expiration = System.currentTimeMillis() + jwtParam.getJwtExpiration();
    
        token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(expiration))
                .signWith(SignatureAlgorithm.HS512, jwtParam.getJwtSecret())
                .compact();
    
        token = jwtParam.getJwtTokenHead() + token;
        
        ModelJson<Map> json = new ModelJson<>();
        Map data = new HashMap();
        data.put("token", token);
        data.put("expiration", expiration);
        
        return json.setData(data);
    }
}
