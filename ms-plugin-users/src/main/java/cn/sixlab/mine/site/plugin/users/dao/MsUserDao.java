/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/8 21:16
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.plugin.users.dao;

import cn.sixlab.mine.site.plugin.users.bean.MsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MsUserDao extends JpaRepository<MsUser, Integer> {
    
    @Query("select u from MsUser u where u.username = ?1 ")
    MsUser findByUsername(String username);
    
}
