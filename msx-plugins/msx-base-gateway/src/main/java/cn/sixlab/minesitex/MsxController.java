/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/29 15:38
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex;

import cn.sixlab.minesitex.api.user.IUserService;
import cn.sixlab.minesitex.bean.user.vo.UserAndRoleVo;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MsxController {
    
    @Autowired
    private IUserService service;
    
    @ResponseBody
    @RequestMapping("/username/pub/{username}")
    public ModelJson<UserAndRoleVo> loadUserByUsername(@PathVariable("username") String username) {
        return service.loadUserByUsername(username);
    }
    
}
