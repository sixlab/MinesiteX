/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/13 15:21
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.plugin.archives.service;

import cn.sixlab.mine.site.plugin.archives.bean.MsCategory;
import cn.sixlab.mine.site.plugin.archives.repository.CategoryRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;
    
    public void addCategory(String category) {
        if (StringUtils.isNotEmpty(category)) {
            MsCategory msCategory = repository.findByCategory(category);
            if (null == msCategory) {
                msCategory = new MsCategory();
                msCategory.setCategory(category);
                msCategory.setArchiveCount(0);
                repository.save(msCategory);
            } else {
                msCategory.setArchiveCount(1 + msCategory.getArchiveCount());
            }
        }
    }
    
    public void minusCategory(String category) {
        if (StringUtils.isNotEmpty(category)) {
            MsCategory msCategory = repository.findByCategory(category);
            
            if (msCategory != null) {
                int count = msCategory.getArchiveCount() - 1;
                if (count < 0) {
                    count = 0;
                }
                msCategory.setArchiveCount(count);
                repository.save(msCategory);
            }
        }
    }
    
}
