package com.riskAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.riskAssessment.intefaceRepository")
@EntityScan("com.riskAssessment.POJO")
// @EnableAutoConfiguration (exclude = { DataSourceAutoConfiguration.class })
public class MainApplication {
    public static void main(String[] args) throws Exception {
	SpringApplication.run(MainApplication.class, args);

    }
}
