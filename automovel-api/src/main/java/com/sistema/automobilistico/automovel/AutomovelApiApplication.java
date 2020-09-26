package com.sistema.automobilistico.automovel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AutomovelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomovelApiApplication.class, args);
	}

}
