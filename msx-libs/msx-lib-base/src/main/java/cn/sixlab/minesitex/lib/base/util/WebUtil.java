/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/28 18:06
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base.util;


import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class WebUtil {
    
    public static String readToken(HttpServletRequest request, String jwtHeader) {
        String token = request.getHeader(jwtHeader);
        
        if (StringUtils.isEmpty(token)) {
            Cookie[] cookies = request.getCookies();
            if (null != cookies && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if (jwtHeader.equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        
        return token;
    }
}
