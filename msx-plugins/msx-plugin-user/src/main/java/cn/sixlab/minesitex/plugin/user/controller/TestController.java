/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/27 14:07
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.user.controller;

import cn.sixlab.minesitex.api.user.IUserService;
import cn.sixlab.minesitex.bean.user.vo.UserAndRoleVo;
import cn.sixlab.minesitex.lib.base.BaseController;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/test/pub")
public class TestController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @Autowired
    private IUserService service;
    
    @RequestMapping("/username/{username}")
    public ModelJson<UserAndRoleVo> loadUserByUsername(@PathVariable("username") String username) {
        return service.loadUserByUsername(username);
    }
    
}
