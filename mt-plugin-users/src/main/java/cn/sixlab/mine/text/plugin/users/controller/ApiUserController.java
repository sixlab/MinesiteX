/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/9 17:00
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.text.plugin.users.controller;

import cn.sixlab.mine.text.core.ModelJson;
import cn.sixlab.mine.text.plugin.users.bean.MtUser;
import cn.sixlab.mine.text.plugin.users.dao.MtUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {
    
    @Autowired
    private MtUserDao userDao;
    
    @RequestMapping(value = {"/my", "/pub/my"})
    public ModelJson loadUserByUsername(String username) {
        ModelJson json = new ModelJson();
        
        MtUser mtUser = userDao.findByUsername(username);
        json.put("user", mtUser);
        
        return json;
    }
}
