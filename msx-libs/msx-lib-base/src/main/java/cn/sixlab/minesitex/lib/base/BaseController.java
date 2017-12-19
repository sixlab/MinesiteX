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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        dateFormat.setLenient(false);
    
        // Date 类型  true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                if (!StringUtils.isEmpty(value)) {
                    setValue(new Date(Long.valueOf(value)));
                }
            }
        });
    
        // Timestamp 类型
        binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                if (!StringUtils.isEmpty(value)) {
                    setValue(new Timestamp(Long.valueOf(value)));
                }
            }
        });

        //        //// LocalDate 类型
        //        //binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
        //        //    @Override
        //        //    public void setAsText(String value) {
        //        //        if (!StringUtils.isEmpty(value)) {
        //        //            setValue(Instant.ofEpochMilli(Long.valueOf(value)).atZone(ZoneId.systemDefault()).toLocalDate());
        //        //        }
        //        //    }
        //        //});
        //
        //// LocalDateTime 类型
        //binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
        //    @Override
        //    public void setAsText(String value) {
        //        if (!StringUtils.isEmpty(value)) {
        //            setValue(Instant.ofEpochMilli(Long.valueOf(value)).atZone(ZoneId.systemDefault()).toLocalDateTime());
        //        }
        //    }
        //});
        //
        //// LocalTime 类型
        //binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
        //    @Override
        //    public void setAsText(String value) {
        //        if (!StringUtils.isEmpty(value)) {
        //            setValue(Instant.ofEpochMilli(Long.valueOf(value)).atZone(ZoneId.systemDefault()).toLocalTime());
        //        }
        //    }
        //});
    }
}
