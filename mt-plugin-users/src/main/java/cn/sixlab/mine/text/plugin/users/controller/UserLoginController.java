/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/8 21:12
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.text.plugin.users.controller;

import cn.sixlab.mine.text.core.ModelJson;
import cn.sixlab.mine.text.plugin.users.bean.MtUser;
import cn.sixlab.mine.text.plugin.users.dao.MtUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserLoginController {
    
    @Autowired
    private MtUserDao userDao;
    
    @RequestMapping("/login")
    public ModelJson toString(String username, String password, HttpServletRequest request,
            HttpServletResponse response) {
        ModelJson json = new ModelJson();
        
        MtUser mtUser = userDao.findByUsername(username);
        
        if (null != mtUser) {
            if (BCrypt.checkpw(password, mtUser.getPassword())) {
                return json;
            }
        }
        json.setErrorMessage("登录错误", 10001);
        
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
        
        Cookie cookie = new Cookie("ts1t", "-----");
        cookie.setMaxAge(100000);
        cookie.setPath("/");
        response.addCookie(cookie);
        
        return json;
    }
    
    @RequestMapping("/loadUserByUsername")
    public ModelJson loadUserByUsername(String username) {
        ModelJson json = new ModelJson();
        
        MtUser mtUser = userDao.findByUsername(username);
        json.put("user", mtUser);
        
        return json;
    }
}
