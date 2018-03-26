package com.risk.producerconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.risk.producerpojo.Airport;

@Configuration
public class KafkaAirportProducerConfig {

	@Autowired
	private KafkaProducerCommonProperty property;

	@Value("${kafka.topic-airport}")
	private String topic;

	@SuppressWarnings("unchecked")
	@Bean
	public ProducerFactory<Integer, Airport> producerFactory() {
		return new DefaultKafkaProducerFactory<>(property.producerConfigs(), property.setIntegerKeySerializer(),
				property.setJsonSerializer());
	}

	@Bean
	public KafkaTemplate<Integer, Airport> airportKafkaTemplate() {

		KafkaTemplate<Integer, Airport> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		kafkaTemplate.setDefaultTopic(topic);
		return kafkaTemplate;
	}

}
