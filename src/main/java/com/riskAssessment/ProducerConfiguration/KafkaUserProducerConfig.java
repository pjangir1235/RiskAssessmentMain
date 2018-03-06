package com.riskAssessment.ProducerConfiguration;

import javax.validation.constraints.Null;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.riskAssessment.ProducerPOJO.PilotDesignation;
import com.riskAssessment.ProducerPOJO.User;

@Configuration
public class KafkaUserProducerConfig {

	@Autowired
	private KafkaProducerCommonProperty property;

	@Value("${kafka.topic-user}")
	private String topic;

	@Bean
	public ProducerFactory<Integer, User> producerFactory() {
		return new DefaultKafkaProducerFactory<>(property.producerConfigs(), property.setIntegerKeySerializer(), property.setJsonSerializer());
	}

	@Bean
	public KafkaTemplate<Integer, User> userKafkaTemplate() {

		KafkaTemplate<Integer, User> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		kafkaTemplate.setDefaultTopic(topic);
		return kafkaTemplate;
	}
}
