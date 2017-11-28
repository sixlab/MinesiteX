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
package cn.sixlab.minesitex.plugin.user.service;

import cn.sixlab.minesitex.api.user.IUserService;
import cn.sixlab.minesitex.bean.user.entity.MsxUser;
import cn.sixlab.minesitex.bean.user.entity.MsxUserRole;
import cn.sixlab.minesitex.bean.user.vo.UserAndRoleVo;
import cn.sixlab.minesitex.data.user.UserRepo;
import cn.sixlab.minesitex.data.user.UserRoleRepo;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
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
    
    public ModelJson<UserAndRoleVo> loadUserByUsername(String username) {
        MsxUser user = userRepo.findByUsername(username);
        return loadUserRole(user);
    }
    
    public ModelJson<UserAndRoleVo> loadUserById(Integer userId) {
        MsxUser user = userRepo.findOne(userId);
        return loadUserRole(user);
    }
    
    private ModelJson<UserAndRoleVo> loadUserRole(MsxUser user) {
        ModelJson<UserAndRoleVo> json = new ModelJson<>();
        
        UserAndRoleVo vo = new UserAndRoleVo();
        vo.setUser(user);
    
        List<MsxUserRole> roleList = new ArrayList<>();
        if(null!=user){
            roleList = roleRepo.findByUserId(user.getId());
        }
        vo.setRoleList(roleList);
    
        return json.setData(vo);
    }
}
