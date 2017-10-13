/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/13 14:45
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.site.plugin.archives.bean;

import org.springframework.data.annotation.Id;

public class MsTag {
    
    @Id
    private String id;
    private String tag;
    private String description;
    private String uri;
    private int archiveCount;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getUri() {
        return uri;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    public int getArchiveCount() {
        return archiveCount;
    }
    
    public void setArchiveCount(int archiveCount) {
        this.archiveCount = archiveCount;
    }
}
