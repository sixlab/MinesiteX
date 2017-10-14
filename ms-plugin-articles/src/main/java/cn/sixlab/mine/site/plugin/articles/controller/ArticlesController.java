/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/12 20:27
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.plugin.articles.controller;

import cn.sixlab.mine.site.lib.core.bean.ModelJson;
import cn.sixlab.mine.site.plugin.articles.bean.MsArticle;
import cn.sixlab.mine.site.plugin.articles.service.ArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController {
    
    @Autowired
    private ArticleService service;
    
    @RequestMapping(value = "/article/{url}", method = RequestMethod.GET)
    public ModelJson article(@PathVariable String url) {
        ModelJson json = new ModelJson();
        
        MsArticle msArticle = service.getArticle(url);
        json.put("article", msArticle);
        
        return json;
    }
    
    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
    public ModelJson delArticle(@PathVariable String id) {
        ModelJson json = new ModelJson();
        
        service.delArticle(id);
        
        return json;
    }
    
    @RequestMapping(value = "/article/{id}", method = RequestMethod.POST)
    public ModelJson submitArticle(@PathVariable String id, MsArticle msArticle) {
        ModelJson json = new ModelJson();
    
        if (StringUtils.isNotEmpty(id)) {
            msArticle = service.modifyArticle(msArticle);
        } else {
            msArticle = service.addArticle(msArticle);
        }
        json.put("article", msArticle);
        
        return json;
    }
}
