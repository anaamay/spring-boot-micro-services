package com.ril.fb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RilFbRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RilFbRegistryServerApplication.class, args);
	}

}
