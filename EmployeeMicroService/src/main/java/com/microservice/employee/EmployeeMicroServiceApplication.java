package com.microservice.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMicroServiceApplication.class, args);
	}

}
