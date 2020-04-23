package com.ril.fb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableEurekaClient
public class RilFbShoppingCartServiceApplication {
	
	@GetMapping("/welcome")
	public String sayHello() {
		return "Welcome...";
	}
	public static void main(String[] args) {
		SpringApplication.run(RilFbShoppingCartServiceApplication.class, args);
	}

}
