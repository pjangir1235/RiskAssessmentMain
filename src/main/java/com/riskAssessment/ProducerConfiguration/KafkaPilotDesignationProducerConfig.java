package com.riskAssessment.ProducerConfiguration;

import org.apache.kafka.common.serialization.StringSerializer;
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
	public ProducerFactory<String, PilotDesignation> producerFactory() {
		return new DefaultKafkaProducerFactory<>(property.producerConfigs(), new StringSerializer(),
				property.setJsonSerializer());
	}

	@Bean
	public KafkaTemplate<String, PilotDesignation> pilotDesignationKafkaTemplate() {

		KafkaTemplate<String, PilotDesignation> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		kafkaTemplate.setDefaultTopic(topic);
		return kafkaTemplate;
	}
}
