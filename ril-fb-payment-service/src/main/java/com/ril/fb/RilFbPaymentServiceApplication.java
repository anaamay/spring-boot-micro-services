package com.ril.fb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RilFbPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RilFbPaymentServiceApplication.class, args);
	}

}
