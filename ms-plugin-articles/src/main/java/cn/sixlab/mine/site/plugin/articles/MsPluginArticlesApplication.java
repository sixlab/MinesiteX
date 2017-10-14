package cn.sixlab.mine.site.plugin.articles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsPluginArticlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPluginArticlesApplication.class, args);
	}
}
