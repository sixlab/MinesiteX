/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/8 17:17
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.base.gateway;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    public static void main(String[] args) {
        Date date = new Date(new Date().getTime() + 3024000000l);
        String compact = "Bearer "+Jwts.builder()
                .setSubject("nianqinianyi")
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, "Sixlab's MinesiteX")
                .compact();
    //Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuaWFucWluaWFueWkiLCJleHAiOjE1MTYxODA3ODN9.bRTUeZvQdrn1bdV8LMJ5hpdUAqOa7wGpgdXS-67ai2bZsFGyoMcUiCuiDVdcsLmov5347E9ShBu_iSbxnKbujA
    //Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuaWFucWluaWFueWkiLCJleHAiOjE1MTMxNTcwMDR9.PhnpYCUsmMet84LTrhfdRbdoJV24u7wbNUEFedR4QDBmdDI8HqP4uLUsS5JIx_zSzFijm0DYK80Yyey7c2RjQQ
        System.out.println(date);
        System.out.println(compact);
    }
}
