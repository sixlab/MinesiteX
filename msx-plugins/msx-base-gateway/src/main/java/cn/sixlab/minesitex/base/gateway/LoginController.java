/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/9 09:22
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.base.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @RequestMapping(value = {"", "/", "/index"})
    public String index() {
        String result = "r index";
        return result;
    }
    
    @RequestMapping("/in/test")
    public String index1() {
        String result = "in test";
        return result;
    }
    
    @RequestMapping("/in/pub/test")
    public String index2() {
        String result = "pub test";
        return result;
    }
}