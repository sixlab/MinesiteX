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

import cn.sixlab.minesitex.bean.user.entity.MsxUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepo extends JpaRepository<MsxUserRole, Integer>{
    
    List<MsxUserRole> findByUserId(@Param("userId") Integer userId);
}
