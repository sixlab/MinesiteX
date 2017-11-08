/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/20
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.base.gateway.security;

import cn.sixlab.minesitex.api.user.IUserService;
import cn.sixlab.minesitex.bean.user.entity.MsxUserRole;
import cn.sixlab.minesitex.bean.user.vo.UserAndRoleVo;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JWTUserDetailsService implements UserDetailsService {
    
    @Autowired
    private IUserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        
        ModelJson<UserAndRoleVo> json = userService.loadUserByUsername(username);
        UserAndRoleVo userAndRole = json.getData();
        
        if (null == userAndRole || null == userAndRole.getUser()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            List<GrantedAuthority> authorityList;
            
            List<MsxUserRole> roleList = userAndRole.getRoleList();
            if (CollectionUtils.isEmpty(roleList)) {
                authorityList = new ArrayList<>();
                authorityList.add(new SimpleGrantedAuthority("USER"));
            } else {
                authorityList = roleList.stream()
                        .map(msxUserRole -> new SimpleGrantedAuthority(msxUserRole.getRole()))
                        .collect(Collectors.toList());
            }
            
            return new User(
                    username, String.valueOf(userAndRole.getUser().getPassword()),
                    true,//账户可用为true
                    true,//账户未过期为true
                    true,//证书不过期为true
                    true,//账户未锁定为true
                    authorityList);
        }
    }
}
