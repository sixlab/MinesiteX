package cn.sixlab.minesitex;

import cn.sixlab.minesitex.base.zuul.security.AuthFilter;
import cn.sixlab.minesitex.base.zuul.security.MsUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MsBaseZuulApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MsBaseZuulApplication.class, args);
    
        MsUser msUser = context.getBean(MsUser.class);
        
        System.out.println("用户 API Secret：\n"+new BCryptPasswordEncoder().encode(msUser.toString()));
    }
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}
