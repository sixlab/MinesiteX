package cn.sixlab.minesitex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsBaseEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBaseEurekaApplication.class, args);
	}
}
