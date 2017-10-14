/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/13 15:01
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.plugin.articles.repository;

import cn.sixlab.mine.site.plugin.articles.bean.MsCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<MsCategory, String> {
    MsCategory findByCategory(String category);
}
