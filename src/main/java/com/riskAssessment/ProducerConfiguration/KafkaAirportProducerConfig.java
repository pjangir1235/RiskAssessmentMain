package com.riskAssessment.ProducerConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.riskAssessment.POJO.Airport_Location;

@Configuration
public class KafkaAirportProducerConfig {

    @Autowired
    private KafkaProducerCommonProperty property;

    @Value("${kafka.topic-airport}")
    private String topic;

    @Bean
    public ProducerFactory<Integer, Airport_Location> producerFactory() {
	return new DefaultKafkaProducerFactory<>(property.producerConfigs(), property.setIntegerKeySerializer(),
		property.setJsonSerializer());
    }

    @Bean
    public KafkaTemplate<Integer, Airport_Location> aircraftKafkaTemplate() {

	KafkaTemplate<Integer, Airport_Location> kafkaTemplate = new KafkaTemplate<>(producerFactory());
	kafkaTemplate.setDefaultTopic(topic);
	return kafkaTemplate;
    }

}
