package cn.sixlab.mine.text.base.zuul;

import cn.sixlab.mine.text.base.zuul.filter.LoginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MtBaseZuulApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MtBaseZuulApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public LoginFilter loginFilter() {
        return new LoginFilter();
    }
}
