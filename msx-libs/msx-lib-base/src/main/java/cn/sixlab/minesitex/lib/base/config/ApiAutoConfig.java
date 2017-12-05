/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/29 14:46
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.lib.base.config;

import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 接口中的@RequestMapping也被SpringMVC加载的问题解决
 */
@Configuration
//@ConditionalOnClass({Feign.class})
public class ApiAutoConfig {
    
    @Bean
    public WebMvcRegistrations feignWebRegistrations() {
        return new WebMvcRegistrationsAdapter() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new FeignRequestMappingHandlerMapping();
            }
        };
    }
    
    private static class FeignRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            Package p = beanType.getPackage();
            boolean isHandler = true;
            if (p != null && p.getName().startsWith("cn.sixlab.minesitex.api.")) {
                isHandler = false;
            }
            
            return super.isHandler(beanType) && isHandler;
        }
    }
}
