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

import cn.sixlab.mine.site.plugin.archives.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository repository;
    
    
    public void addTags(String[] tags) {
    
    }
}
