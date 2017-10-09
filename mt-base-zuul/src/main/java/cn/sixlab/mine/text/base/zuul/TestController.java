/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/9 09:22
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.text.base.zuul;

import cn.sixlab.mine.text.core.ModelJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class TestController {
    private final static String serverURI = "http://mt-plugin-users/";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping("r1")
    public String route1() {
        String result = "r11";
        ModelJson json = restTemplate.getForObject(serverURI + "loadUserByUsername?username=" + "caolw", ModelJson.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    
        return result;
    }
    
    @RequestMapping("r2")
    public String route2() {
        String result = "r22";
        ModelJson json = restTemplate.getForObject(serverURI + "loadUserByUsername?username=" + "caolw", ModelJson.class);
    
        Map<String, Object> oj = (Map<String, Object>) json.get("user");
        result = String.valueOf(oj.get("password"));
    
        return result;
    }
}