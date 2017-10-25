/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtl {
    private final static ObjectMapper objectMapper;
    
    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static <T> T toBean(String content, Class<T> clz) {
        
        try {
            return objectMapper.readValue(content, clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static <T> T obj2Bean(Object obj, Class<T> clz) {
        try {
            String json = objectMapper.writeValueAsString(obj);
            if (null != json && !"".equals(json)) {
                return objectMapper.readValue(json, clz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}