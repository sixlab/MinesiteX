/**
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/1/19 08:30
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex;

import cn.sixlab.minesitex.lib.base.BaseController;
import cn.sixlab.minesitex.lib.base.util.ApplicationContextHolder;
import cn.sixlab.minesitex.lib.base.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@RestController
public class AioController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(AioController.class);
    
    @PostMapping(value = "/aio/dynamic")
    public String dynamic(String clz, String method) {
        logger.debug("dynamic");
        
        Object bean = ApplicationContextHolder.getBean(clz);
        
        String result = "null";
        
        if (null != bean) {
            result = "not null";
            Method[] methods = bean.getClass().getMethods();
            if (null != methods && methods.length > 0) {
                result = "method:" + methods.length;
                for (Method item : methods) {
                    if (item.getName().equals(method)) {
                        result = "method bingo";
                        
                        Parameter[] parameters = item.getParameters();
                        
                        if (null != parameters && parameters.length > 0) {
                            result = "method has param";
                            Object[] params = new Object[parameters.length];
                            HttpServletRequest request = WebUtil.getRequest();
                            for (int i = 0; i < parameters.length; i++) {
                                params[i] = request.getParameter(parameters[i].getName());
                            }
                            
                            try {
                                Object invoke = item.invoke(bean, params);
                                result = "method has param success:" + invoke;
                            } catch (IllegalAccessException e) {
                                result = "method has param1:" + e.getMessage();
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                result = "method has param2:" + e.getMessage();
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                result = "method no param";
                                Object invoke = item.invoke(bean);
                                result = "method no param success:" + invoke;
                            } catch (IllegalAccessException e) {
                                result = "method no param1:" + e.getMessage();
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                result = "method no param2:" + e.getMessage();
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
