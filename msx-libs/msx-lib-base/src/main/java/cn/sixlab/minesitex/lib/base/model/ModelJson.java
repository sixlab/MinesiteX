/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/8 21:20
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base.model;

import cn.sixlab.minesitex.lib.base.util.JsonUtl;

import java.io.Serializable;

public class ModelJson <T> implements Serializable{
    private boolean success = true;
    private String flag = "";
    private String message = "";
    private int code = 0;
    private T data = null;
    
    public boolean isSuccess() {
        return success;
    }
    
    public ModelJson<T> setSuccess(boolean success) {
        this.success = success;
    
        return this;
    }
    
    public String getFlag() {
        return flag;
    }
    
    public ModelJson<T> setFlag(String flag) {
        this.flag = flag;
    
        return this;
    }
    
    public String getMessage() {
        return message;
    }
    
    public ModelJson<T> setMessage(String message) {
        this.message = message;
    
        return this;
    }
    
    public int getCode() {
        return code;
    }
    
    public ModelJson<T> setCode(int code) {
        this.code = code;
        
        return this;
    }
    
    public T getData() {
        return data;
    }
    
    public ModelJson<T> setData(T data) {
        this.data = data;
    
        return this;
    }
    
    @Override
    public String toString() {
        String msg = "{}";
        msg = JsonUtl.toJson(this);
        return msg;
    }
}
