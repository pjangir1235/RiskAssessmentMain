package com.riskAssessment.ConsumerConfiguration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import com.riskAssessment.DataStorageConsumerr.StoreRecord;

@Configuration
@EnableKafka
public class ConsumerCommonConfig {

	@Value("${kafka.bootstrap}")
	private String bootstrap;

	@Bean
	public Map<String, Object> consumerConfigs() {

		Map<String, Object> propsMap = new HashMap<>();
		propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
		propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		propsMap.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return propsMap;
	}

	@Bean
	public Deserializer stringKeyDeserializer() {
		return new StringDeserializer();
	}

	@Bean
	public StoreRecord recordData() {
		return new StoreRecord();
	}

}
