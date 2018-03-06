package com.riskAssessment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.riskAssessment.Constraint.SqlConstraint;
import com.riskAssessment.Constraint.QuerySql;
import com.riskAssessment.DataStorageConsumerr.StoreRecord;

@Configuration
public class CommonConfig {

	@Bean
	public StoreRecord store() {
		return new StoreRecord();
	}

}
