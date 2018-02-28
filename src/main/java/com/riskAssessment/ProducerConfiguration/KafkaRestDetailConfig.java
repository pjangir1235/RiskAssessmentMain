package com.riskAssessment.ProducerConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.riskAssessment.ProducerPOJO.RestDetail;

@Configuration
public class KafkaRestDetailConfig {
	@Autowired
	private KafkaProducerCommonProperty property;

	@Value("${kafka.topic-restDetail}")
	private String topic;

	@Bean
	public ProducerFactory<Integer, RestDetail> producerFactory() {
		return new DefaultKafkaProducerFactory<>(property.producerConfigs(), property.setIntegerKeySerializer(),
				property.setJsonSerializer());
	}

	@Bean
	public KafkaTemplate<Integer, RestDetail> restDetailKafkaTemplate() {

		KafkaTemplate<Integer, RestDetail> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		kafkaTemplate.setDefaultTopic(topic);
		return kafkaTemplate;
	}
}
