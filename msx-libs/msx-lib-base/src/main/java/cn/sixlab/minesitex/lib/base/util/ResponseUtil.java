/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/9 18:02
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base.util;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
    public static void setJsonType(HttpServletResponse response){
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
    }
}
