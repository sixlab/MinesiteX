/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/4 11:15
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.api.user.feign;

import cn.sixlab.minesitex.api.user.IUserService;
import cn.sixlab.minesitex.bean.user.vo.UserAndRoleVo;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("msx-plugin-user")
public interface UserServiceFeign extends IUserService {
    
    @GetMapping(
            value = {"/user/username/{username}"},
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    ModelJson<UserAndRoleVo> loadUserByUsername(@PathVariable("username") String username);
    
    @GetMapping(
            value = {"/user/id/{userId}"},
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    ModelJson<UserAndRoleVo> loadUserById(@RequestParam("userId") Integer userId);
}