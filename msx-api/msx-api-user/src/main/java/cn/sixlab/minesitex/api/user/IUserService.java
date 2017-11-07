/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
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

public interface IUserService {
    
    ModelJson<UserAndRoleVo> loadUserByUsername(String username);
    
    ModelJson<UserAndRoleVo> loadUserById(Integer userId);
}