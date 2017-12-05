/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/26 11:12
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        dateFormat.setLenient(false);
    
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                if(null!=value && !"".equals(value)){
                    setValue(new Date(Long.valueOf(value)));
                }
            }
        });
        
    }
}
