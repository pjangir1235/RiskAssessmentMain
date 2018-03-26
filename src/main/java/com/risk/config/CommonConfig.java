package com.risk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.risk.models.StoreRecord;

@Configuration
public class CommonConfig {

	@Bean
	public StoreRecord store() {
		return new StoreRecord();
	}

}
