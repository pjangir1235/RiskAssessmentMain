package com.risk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.risk.producer.intefacerepo")
@EntityScan("com.risk.producer.model")
public class Main {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);

	}
}
