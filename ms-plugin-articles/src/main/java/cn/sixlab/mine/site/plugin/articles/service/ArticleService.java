/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/13 14:41
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.plugin.articles.service;

import cn.sixlab.mine.site.plugin.articles.bean.MsArticle;
import cn.sixlab.mine.site.plugin.articles.repository.ArticleRepository;
import cn.sixlab.mine.site.plugin.articles.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository repository;
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private CategoryService categoryService;
    
    public MsArticle getArticle(String urlOrId) {
        MsArticle article = repository.findByUrl(urlOrId);
        if (null == article) {
            article = repository.findOne(urlOrId);
        }
        
        return article;
    }
    
    public void delArticle(String Id) {
        repository.delete(Id);
    }
    
    public MsArticle addArticle(MsArticle msArticle) {
        String[] tags = msArticle.getTags();
        String category = msArticle.getCategory();
        
        if (Constants.ARTICLE_POST.equals(msArticle.getArticleStatus())) {
            tagService.addTags(tags);
            categoryService.addCategory(category);
        }
        
        msArticle.setCommentCount(0);
        msArticle.setViewCount(0);
        msArticle.setUpdateTime(LocalDateTime.now());
        
        repository.save(msArticle);
        
        return msArticle;
    }
    
    public MsArticle modifyArticle(MsArticle msArticle) {
        
        return msArticle;
    }
}
