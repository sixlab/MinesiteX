/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/12 23:04
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.plugin.articles.repository;

import cn.sixlab.mine.site.plugin.articles.bean.MsArticle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<MsArticle, String>{
    MsArticle findByUrl(String url);
}
