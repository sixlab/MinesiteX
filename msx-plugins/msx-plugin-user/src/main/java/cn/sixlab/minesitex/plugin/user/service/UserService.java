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
package cn.sixlab.minesitex.plugin.user.service;

import cn.sixlab.minesitex.bean.user.entity.MsxUser;
import cn.sixlab.minesitex.bean.user.entity.MsxUserRole;
import cn.sixlab.minesitex.bean.user.vo.UserAndRoleVo;
import cn.sixlab.minesitex.data.user.UserRepo;
import cn.sixlab.minesitex.data.user.UserRoleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService{
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private UserRoleRepo roleRepo;
    
    public UserAndRoleVo loadUserByUsername(String username) {
        MsxUser user = userRepo.findByUsername(username);
        return loadUserRole(user);
    }
    
    public UserAndRoleVo loadUserById(Integer userId) {
        if(null==userId){
            return null;
        }
        MsxUser user = userRepo.findOne(userId);
        return loadUserRole(user);
    }
    
    private UserAndRoleVo loadUserRole(MsxUser user) {
        UserAndRoleVo vo = new UserAndRoleVo();
        vo.setUser(user);
    
        List<MsxUserRole> roleList = new ArrayList<>();
        if(null!=user){
            roleList = roleRepo.findByUserId(user.getId());
        }
        vo.setRoleList(roleList);
    
        return vo;
    }
}
