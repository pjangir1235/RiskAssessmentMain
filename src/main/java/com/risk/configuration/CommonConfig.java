package com.risk.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.risk.datastorageconsumer.StoreRecord;

@Configuration
public class CommonConfig {

	@Bean
	public StoreRecord store() {
		return new StoreRecord();
	}

}
