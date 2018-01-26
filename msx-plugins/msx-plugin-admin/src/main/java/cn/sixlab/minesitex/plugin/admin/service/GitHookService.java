/**
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/1/26 16:53
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.admin.service;

import cn.sixlab.minesitex.lib.base.util.DigestUtil;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import cn.sixlab.minesitex.plugin.admin.business.ServerOperator;
import cn.sixlab.minesitex.plugin.admin.controller.AdminPubController;
import cn.sixlab.minesitex.plugin.admin.controller.WebhooksParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GitHookService {
    private static Logger logger = LoggerFactory.getLogger(AdminPubController.class);
    
    @Autowired
    private WebhooksParam webhooksParam;
    
    public void github(String data, String signature) throws IOException {
        Map obj = JsonUtl.toBean(data, Map.class);
        boolean valid = false;
    
        String sha1 = "sha1=" + DigestUtil.encodeSHA1(data, webhooksParam.getGithubHeader());
        
        logger.info("signature:"+signature);
        logger.info("sha1sha1 :"+ sha1);
    
        // signature = 'sha1=' + OpenSSL::HMAC.hexdigest(OpenSSL::Digest.new('sha1'), ENV['SECRET_TOKEN'], payload_body)
        if(sha1.equals(signature)){
            if ("PatrickRoot/PatrickRoot.github.io".equals(((Map) (obj.get("repository"))).get("full_name"))) {
                ServerOperator.exec("git pull", "/var/www/blogs/");
        
                ServerOperator.exec("hexo gen", "/var/www/blogs/");
            }
        } else {
            logger.error("密码错误：" + obj.get("password"));
        }
    }
    
    public void gitee(String data) throws IOException {
        Map obj = JsonUtl.toBean(data, Map.class);
        if (webhooksParam.getGiteeSecret().equals(obj.get("password"))) {
            if ("configs".equals(((Map) (obj.get("repository"))).get("name"))) {
                List<Map> commits = (List) obj.get("commits");
                for (Map commit : commits) {
                    String msg = commit.get("message").toString();
                    Pattern pattern = Pattern.compile("\\$.*\\(\\s*(.*?)\\s*\\)");
                    Matcher matcher = pattern.matcher(msg);
                    if (matcher.find()) {
                        String text = matcher.group(1);
                        logger.info("操作命令："+text);
                        switch (text){
                            case "nginx":
                                ServerOperator.exec("git pull", "/var/www/configs/");
                                
                                ServerOperator.exec("service nginx reload", null);
                                break;
                            case "msx":
                                //ServerOperator.msxRestart();
                                break;
                        }
                    }
                }
            }
        } else {
            logger.error("密码错误：" + obj.get("password"));
        }
    }
}
