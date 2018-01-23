/**
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/1/23 15:32
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.admin.controller;

import cn.sixlab.minesitex.lib.base.BaseController;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@RestController
@RequestMapping("/admin/pub")
public class AdminPubController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(AdminPubController.class);
    
    @PostMapping(value = "/github/webhooks/{repo}")
    public String webhooks(@RequestBody String data, HttpServletRequest request, @PathVariable String repo) throws IOException {
        System.out.println("来自："+repo);
        System.out.println(data);
        System.out.println(request.getHeader("X-Hub-Signature"));
        if(StringUtils.hasLength(data)){
            Map obj = JsonUtl.toBean(data, Map.class);
            if("PatrickRoot/PatrickRoot.github.io".equals(((Map) (obj.get("repository"))).get("full_name"))){
                Process proc1 = Runtime.getRuntime().exec("git pull", null, new File("/var/www/blogs/"));
                BufferedReader br = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                System.out.println(sb.toString());
    
                System.out.println("---------------");
                
                Process proc2 = Runtime.getRuntime().exec("hexo gen", null, new File("/var/www/blogs/"));
                BufferedReader br2 = new BufferedReader(new InputStreamReader(proc2.getInputStream()));
                String line2;
                StringBuilder sb2 = new StringBuilder();
                while ((line2 = br2.readLine()) != null) {
                    sb2.append(line2 + "\n");
                }
                System.out.println(sb2.toString());
            }
        }
        return "ok";
    }
}
