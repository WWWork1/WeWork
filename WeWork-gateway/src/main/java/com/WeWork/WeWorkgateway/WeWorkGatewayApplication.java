package com.WeWork.WeWorkgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeWorkGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeWorkGatewayApplication.class, args);
	}

}