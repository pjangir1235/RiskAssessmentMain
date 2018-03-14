package com.risk.producerconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.risk.producerpojo.FlightScheduleCrew;

@Configuration
public class KafkaFlightScheduleCrewProducerConfig {
	@Autowired
	private KafkaProducerCommonProperty property;

	@Value("${kafka.topic-flightScheduleCrew}")
	private String topic;

	@SuppressWarnings("unchecked")
	@Bean
	public ProducerFactory<Integer, FlightScheduleCrew> producerFactory() {
		return new DefaultKafkaProducerFactory<>(property.producerConfigs(), property.setIntegerKeySerializer(),
				property.setJsonSerializer());
	}

	@Bean
	public KafkaTemplate<Integer, FlightScheduleCrew> flightScheduleCrewKafkaTemplate() {

		KafkaTemplate<Integer, FlightScheduleCrew> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		kafkaTemplate.setDefaultTopic(topic);
		return kafkaTemplate;
	}

}
