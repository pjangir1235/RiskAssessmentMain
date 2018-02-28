package com.riskAssessment.ProducerConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.riskAssessment.ProducerPOJO.AircraftType;

@Configuration
public class KafkaAircraftTypeProducerConfig {
	@Autowired
	private KafkaProducerCommonProperty property;

	@Value("${kafka.topic-aircraftType}")
	private String topic;

	@Bean
	public ProducerFactory<Integer, AircraftType> producerFactory() {
		return new DefaultKafkaProducerFactory<>(property.producerConfigs(), property.setIntegerKeySerializer(),
				property.setJsonSerializer());
	}

	@Bean
	public KafkaTemplate<Integer, AircraftType> aircraftTypetKafkaTemplate() {

		KafkaTemplate<Integer, AircraftType> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		kafkaTemplate.setDefaultTopic(topic);
		return kafkaTemplate;
	}
}
