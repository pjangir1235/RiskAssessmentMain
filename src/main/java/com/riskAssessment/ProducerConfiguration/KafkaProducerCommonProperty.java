package com.riskAssessment.ProducerConfiguration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaProducerCommonProperty {

    @Value("${kafka.bootstrap}")
    private String bootstrap;

    @Bean
    public Map<String, Object> producerConfigs() {
	Map<String, Object> props = new HashMap<>();
	props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
	return props;
    }

    @Bean
    public Serializer setIntegerKeySerializer() {
	return new IntegerSerializer();
    }

    @Bean
    public Serializer setJsonSerializer() {
	return new JsonSerializer();
    }

}
