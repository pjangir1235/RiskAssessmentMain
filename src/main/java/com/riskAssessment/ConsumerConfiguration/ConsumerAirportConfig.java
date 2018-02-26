package com.riskAssessment.ConsumerConfiguration;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.riskAssessment.ConsumerPOJO.Airport_Data;

@Configuration
@EnableKafka
public class ConsumerAirportConfig {

	@Autowired
	ConsumerCommonConfig commonProp;

	@Bean
	public Deserializer FlightScheduleJsonValueDeserializer() {
		return new JsonDeserializer(Airport_Data.class);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Airport_Data> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Airport_Data> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConcurrency(10);
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, Airport_Data> consumerFactory() {

		return new DefaultKafkaConsumerFactory<>(commonProp.consumerConfigs(), commonProp.stringKeyDeserializer(),
				FlightScheduleJsonValueDeserializer());
	}

}
