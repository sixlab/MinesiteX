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
package cn.sixlab.mine.text.base.zuul;

import cn.sixlab.mine.text.core.ModelJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class MtUserDetailsService implements UserDetailsService {
    private final static String serverURI = "http://mt-plugin-users/";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        
        ModelJson json = restTemplate.getForObject(serverURI + "loadUserByUsername?username=" + username, ModelJson.class);
        
        if (null != json) {
            Object user = json.get("user");
            if (null != user) {
                Object password = ((Map<String, Object>) user).get("password");
                
                Set<GrantedAuthority> authorities = new HashSet<>();
                authorities.add(new SimpleGrantedAuthority("user"));
                
                return new User(
                        username, String.valueOf(password),
                        true,//账户可用为true
                        true,//账户未过期为true
                        true,//证书不过期为true
                        true,//账户未锁定为true
                        authorities);
            }
        }
        
        throw new UsernameNotFoundException("用户不存在");
    }
}
