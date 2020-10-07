package com.ms.crudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
public class CrudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudServiceApplication.class, args);
	}

}
