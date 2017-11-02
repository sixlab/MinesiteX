/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/27 14:07
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.user.controller;

import cn.sixlab.minesitex.bean.user.vo.UserAndRoleVo;
import cn.sixlab.minesitex.lib.base.BaseController;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import cn.sixlab.minesitex.plugin.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService service;
    
    @GetMapping("/user/username/{username}")
    public ModelJson<UserAndRoleVo> loadUserByUsername(@PathVariable("username") String username) {
        ModelJson<UserAndRoleVo> json = new ModelJson<>();
        
        UserAndRoleVo vo = service.loadUserByUsername(username);
        json.setData(vo);
        
        return json;
    }
    
    @GetMapping("/user/id/{userId}")
    public ModelJson<UserAndRoleVo> loadUserById(@PathVariable("userId") Integer userId) {
        ModelJson<UserAndRoleVo> json = new ModelJson<>();
    
        UserAndRoleVo vo = service.loadUserById(userId);
        json.setData(vo);
    
        return json;
    }
    
}
