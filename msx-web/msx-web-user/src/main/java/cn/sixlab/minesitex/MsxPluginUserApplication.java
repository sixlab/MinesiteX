package cn.sixlab.minesitex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MsxPluginUserApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MsxPluginUserApplication.class, args);
    }
}
