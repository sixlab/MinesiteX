/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/26 17:29
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.bean.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class MsxUser implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String userStatus;
    private String userType;
    private Date lastPasswordResetDate;
    
    private Timestamp insertTime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserStatus() {
        return userStatus;
    }
    
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    
    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
    
    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
    
    public Timestamp getInsertTime() {
        return insertTime;
    }
    
    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }
}
