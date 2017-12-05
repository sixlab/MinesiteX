/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/12/5 16:50
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
@RequestMapping("/error")
public class ErrorController {
    
    @RequestMapping("/500")
    public String e500(HttpServletRequest request, ModelMap model) {
        buildBody(request, model);
        return "error/500";
    }
    
    @RequestMapping("/404")
    public String e404(HttpServletRequest request, ModelMap model) {
        buildBody(request,model);
        return "error/404";
    }
    
    private void buildBody(HttpServletRequest request, ModelMap model) {
        Enumeration<String> attributeNames = request.getAttributeNames();
        if(null!=attributeNames){
            while (attributeNames.hasMoreElements()){
                String element = attributeNames.nextElement();
                model.put(element,request.getAttribute(element));
            }
        }
    }
}
