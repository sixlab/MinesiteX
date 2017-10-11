package cn.sixlab.mine.site.plugin.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsPluginUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPluginUsersApplication.class, args);
	}
}
