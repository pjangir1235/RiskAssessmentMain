package com.riskAssessment.ProducerConfiguration;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.riskAssessment.ProducerPOJO.PilotDesignation;

@Configuration
public class KafkaPilotDesignationProducerConfig {

	@Autowired
	private KafkaProducerCommonProperty property;

	@Value("${kafka.topic-pilotDesignation}")
	private String topic;

	@Bean
	public ProducerFactory<Null, PilotDesignation> producerFactory() {
		return new DefaultKafkaProducerFactory<>(property.producerConfigs(), null, property.setJsonSerializer());
	}

	@Bean
	public KafkaTemplate<Null, PilotDesignation> pilotDesignationKafkaTemplate() {

		KafkaTemplate<Null, PilotDesignation> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		kafkaTemplate.setDefaultTopic(topic);
		return kafkaTemplate;
	}
}
