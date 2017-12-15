package cn.sixlab.minesitex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MsxPluginAssignmentApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MsxPluginAssignmentApplication.class, args);
    }
}
