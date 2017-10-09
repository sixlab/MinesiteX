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
package cn.sixlab.mine.text.core;

import java.util.LinkedHashMap;

public class ModelJson extends LinkedHashMap<String, Object> {
    private boolean success = true;
    private String flag = "";
    private String message = "";
    private int code = 0;
    
    public ModelJson() {
        setSuccess(true);
        setMessage("");
        setFlag("");
        setCode(0);
    }
    
    public int getCode() {
        return code;
    }
    
    public ModelJson setCode(int code) {
        put("code", code);
        this.code = code;
    
        return this;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public ModelJson setSuccess(boolean success) {
        put("success", success);
        this.success = success;
    
        return this;
    }
    
    public String getFlag() {
        return flag;
    }
    
    public ModelJson setFlag(String flag) {
        put("flag", flag);
        this.flag = flag;
    
        return this;
    }
    
    public String getMessage() {
        return message;
    }
    
    public ModelJson setMessage(String message) {
        put("message", message);
        this.message = message;
    
        return this;
    }
    
    public ModelJson setErrorMessage(String message) {
        setSuccess(false);
        setMessage(message);
    
        return this;
    }
    
    public ModelJson setErrorMessage(String message, int code) {
        setSuccess(false);
        setMessage(message);
        setCode(code);
        
        return this;
    }
    //
    //@Override
    //public String toString() {
    //    ObjectMapper objectMapper = new ObjectMapper();
    //    String msg = "{}";
    //    try {
    //        msg = objectMapper.writeValueAsString(this);
    //    } catch (JsonProcessingException e) {
    //        e.printStackTrace();
    //    }
    //    return msg;
    //}
}
