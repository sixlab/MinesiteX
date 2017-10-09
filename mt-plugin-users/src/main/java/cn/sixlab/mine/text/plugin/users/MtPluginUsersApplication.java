package cn.sixlab.mine.text.plugin.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MtPluginUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtPluginUsersApplication.class, args);
	}
}
