/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/1 20:55
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.bean.user.vo;

import cn.sixlab.minesitex.bean.user.entity.MsxUser;
import cn.sixlab.minesitex.bean.user.entity.MsxUserRole;

import java.io.Serializable;
import java.util.List;

public class UserAndRoleVo implements Serializable{
    private MsxUser user;
    private List<MsxUserRole> roleList;
    
    public MsxUser getUser() {
        return user;
    }
    
    public void setUser(MsxUser user) {
        this.user = user;
    }
    
    public List<MsxUserRole> getRoleList() {
        return roleList;
    }
    
    public void setRoleList(List<MsxUserRole> roleList) {
        this.roleList = roleList;
    }
}
