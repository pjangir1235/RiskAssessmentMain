package com.risk.consumer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class ConsumerAircraftCodeTypeConfig {

	@Autowired
	ConsumerCommonConfig config;

	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, AircraftData> aircraftConsumerFactory() {
		Map<String, Object> props = config.commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "aircraft");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
		                new JsonDeserializer(AircraftData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AircraftData> aircraftKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AircraftData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(aircraftConsumerFactory());
		return factory;
	}*/



}
