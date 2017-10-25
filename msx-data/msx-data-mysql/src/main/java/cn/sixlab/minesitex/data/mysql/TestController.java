/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/26 00:24
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.data.mysql;

import cn.sixlab.minesitex.lib.base.model.ModelJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
public class TestController {
    
    @Autowired
    private StringRedisTemplate strTpl;
    
    @RequestMapping("/put")
    public String str() {
        strTpl.opsForValue().set("my-val", String.valueOf(new Random().nextInt()));
        return strTpl.opsForValue().get("my-val");
    }

    @RequestMapping("/get")
    public String get() {
        return strTpl.opsForValue().get("my-val");
    }
    
}
