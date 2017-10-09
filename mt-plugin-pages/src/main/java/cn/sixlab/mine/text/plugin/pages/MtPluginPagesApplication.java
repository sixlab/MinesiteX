package cn.sixlab.mine.text.plugin.pages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MtPluginPagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtPluginPagesApplication.class, args);
	}
}
