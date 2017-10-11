/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/8 21:12
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.plugin.users.controller;

import cn.sixlab.mine.site.core.ModelJson;
import cn.sixlab.mine.site.plugin.users.bean.MsUser;
import cn.sixlab.mine.site.plugin.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    
    @Autowired
    private UserService service;
    
    @RequestMapping("/loadUserByUsername")
    public ModelJson loadUserByUsername(String username) {
        ModelJson json = new ModelJson();
        
        MsUser msUser = service.findByUsername(username);
        json.put("user", msUser);
        
        return json;
    }
}
