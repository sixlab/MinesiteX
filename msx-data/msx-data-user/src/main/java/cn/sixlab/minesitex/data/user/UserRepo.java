/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/27 14:03
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.data.user;

import cn.sixlab.minesitex.bean.user.entity.MsxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<MsxUser, Integer>{
    
    MsxUser findByUsername(@Param("username") String username);
}
