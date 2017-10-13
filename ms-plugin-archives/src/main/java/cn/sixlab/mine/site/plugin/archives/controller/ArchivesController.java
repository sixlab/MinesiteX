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
package cn.sixlab.mine.site.plugin.archives.controller;

import cn.sixlab.mine.site.lib.core.bean.ModelJson;
import cn.sixlab.mine.site.plugin.archives.bean.MsArchive;
import cn.sixlab.mine.site.plugin.archives.service.ArchiveService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/archives")
public class ArchivesController {
    
    @Autowired
    private ArchiveService service;
    
    @RequestMapping(value = "/archive/{url}", method = RequestMethod.GET)
    public ModelJson archive(@PathVariable String url) {
        ModelJson json = new ModelJson();
        
        MsArchive msArchive = service.getArchive(url);
        json.put("archive", msArchive);
        
        return json;
    }
    
    @RequestMapping(value = "/archive/{id}", method = RequestMethod.DELETE)
    public ModelJson delArchive(@PathVariable String id) {
        ModelJson json = new ModelJson();
        
        service.delArchive(id);
        
        return json;
    }
    
    @RequestMapping(value = "/archive/{id}", method = RequestMethod.POST)
    public ModelJson submitArchive(@PathVariable String id, MsArchive msArchive) {
        ModelJson json = new ModelJson();
    
        if (StringUtils.isNotEmpty(id)) {
            msArchive = service.modifyArchive(msArchive);
        } else {
            msArchive = service.addArchive(msArchive);
        }
        json.put("archive", msArchive);
        
        return json;
    }
}
