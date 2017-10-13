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
package cn.sixlab.mine.site.plugin.archives.service;

import cn.sixlab.mine.site.plugin.archives.bean.MsArchive;
import cn.sixlab.mine.site.plugin.archives.repository.ArchiveRepository;
import cn.sixlab.mine.site.plugin.archives.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArchiveService {
    
    @Autowired
    private ArchiveRepository repository;
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private CategoryService categoryService;
    
    public MsArchive getArchive(String urlOrId) {
        MsArchive archive = repository.findByUrl(urlOrId);
        if (null == archive) {
            archive = repository.findOne(urlOrId);
        }
        
        return archive;
    }
    
    public void delArchive(String Id) {
        repository.delete(Id);
    }
    
    public MsArchive addArchive(MsArchive msArchive) {
        String[] tags = msArchive.getTags();
        String category = msArchive.getCategory();
        
        if (Constants.ARCHIVE_POST.equals(msArchive.getArchiveStatus())) {
            tagService.addTags(tags);
            categoryService.addCategory(category);
        }
        
        msArchive.setCommentCount(0);
        msArchive.setViewCount(0);
        msArchive.setUpdateTime(LocalDateTime.now());
        
        repository.save(msArchive);
        
        return msArchive;
    }
    
    public MsArchive modifyArchive(MsArchive msArchive) {
        
        return msArchive;
    }
}
