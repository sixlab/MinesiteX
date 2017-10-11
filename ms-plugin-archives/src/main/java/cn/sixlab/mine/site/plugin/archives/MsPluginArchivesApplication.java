package cn.sixlab.mine.site.plugin.archives;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsPluginArchivesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPluginArchivesApplication.class, args);
	}
}
