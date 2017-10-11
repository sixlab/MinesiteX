/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/9 18:02
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.core;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
    public static void setJsonType(HttpServletResponse response){
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
    }
}
