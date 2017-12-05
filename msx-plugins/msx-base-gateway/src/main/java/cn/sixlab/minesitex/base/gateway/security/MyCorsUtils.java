/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/24 14:11
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.base.gateway.security;

import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;

public abstract class MyCorsUtils {
    public MyCorsUtils() {
    }
    
    public static boolean isCorsRequest(HttpServletRequest request) {
        String origin = request.getHeader("Origin");
        
        return origin != null && origin.toLowerCase().endsWith(".sixlab.cn");
    }
    
    public static boolean isPreFlightRequest(HttpServletRequest request) {
        return isCorsRequest(request)
                && HttpMethod.OPTIONS.matches(request.getMethod())
                && HttpMethod.OPTIONS.matches(request.getMethod())
                && request.getHeader("Access-Control-Request-Method") != null;
    }
}
