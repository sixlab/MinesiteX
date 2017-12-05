/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/30 10:29
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.api.user;

import cn.sixlab.minesitex.bean.user.vo.UserAndRoleVo;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface IUserService {
    
    @GetMapping(value = "/username/{username}")
    ModelJson<UserAndRoleVo> loadUserByUsername(@PathVariable("username") String username);
    
    @GetMapping(value = "/id/{userId}")
    ModelJson<UserAndRoleVo> loadUserById(@PathVariable("userId") Integer userId);
}