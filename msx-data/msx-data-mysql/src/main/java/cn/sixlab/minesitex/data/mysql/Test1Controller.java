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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
public class Test1Controller {
    
    @Autowired
    private RedisTemplate<String, ModelJson> tpl;

    @RequestMapping("/add")
    public ModelJson add() {
        tpl.opsForValue().set("my-value", new ModelJson().setCode(new Random().nextInt()));
        return tpl.opsForValue().get("my-value");
    }

    @RequestMapping("/fetch")
    public ModelJson fetch() {
        return tpl.opsForValue().get("my-value");
    }
    
}
