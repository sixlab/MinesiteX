package cn.sixlab.mine.text.plugin.archives;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MtPluginArchivesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtPluginArchivesApplication.class, args);
	}
}
