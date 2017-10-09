package cn.sixlab.mine.text.base.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MtBaseEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtBaseEurekaApplication.class, args);
	}
}
