package com.risk.consumerconfiguration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.risk.consumerpojo.AircraftChecklistData;
import com.risk.consumerpojo.AircraftData;
import com.risk.consumerpojo.AircraftTypeData;
import com.risk.consumerpojo.AirportData;
import com.risk.consumerpojo.CrewData;
import com.risk.consumerpojo.FlightScheduleCrewData;
import com.risk.consumerpojo.FlightScheduleData;
import com.risk.consumerpojo.FlightSchedulePilotData;
import com.risk.consumerpojo.PilotData;
import com.risk.consumerpojo.PilotDesignationData;
import com.risk.consumerpojo.RestDetailData;
import com.risk.consumerpojo.UserData;

@Configuration
@EnableKafka
public class ConsumerCommonConfig {

	@Value("${kafka.bootstrap}")
	private String bootstrap;
	@Value("${consumer-enable-auto-commit}")
	private Boolean enableCommit;
	@Value("${consumer-auto-commit-interval}")
	private String commitIntervalValue;
	@Value("${consumer-session-timeout}")
	private String sessionTimeOut;
	@Value("${consumer-auto-offset}")
	private String consumerAutoOffset;
	@Value("${consumer-reconnect-backoff}")
	private String reconnectBackoff;

	public Map<String, Object> commonProperty() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableCommit);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, commitIntervalValue);
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeOut);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, consumerAutoOffset);
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, reconnectBackoff);
		return props;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AirportData> airportKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AirportData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(airportConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, AirportData> airportConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "airport");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(AirportData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AircraftData> aircraftKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AircraftData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(aircraftConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, AircraftData> aircraftConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "aircraft");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(AircraftData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AircraftChecklistData> aircraftChecklistKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AircraftChecklistData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(aircraftChecklistConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, AircraftChecklistData> aircraftChecklistConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "aircraftChecklist");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(AircraftChecklistData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AircraftTypeData> aircraftTypeDataKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AircraftTypeData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(aircraftTypeDataConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, AircraftTypeData> aircraftTypeDataConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "aircraftTypeData");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(AircraftTypeData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, CrewData> crewDataKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, CrewData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(crewDataConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, CrewData> crewDataConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "crew");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(CrewData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, FlightScheduleData> flightScheduleKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, FlightScheduleData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(flightScheduleConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, FlightScheduleData> flightScheduleConsumerFactory() {
		Map<String, Object> props = commonProperty();

		props.put(ConsumerConfig.GROUP_ID_CONFIG, "flightSchedule");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(FlightScheduleData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, FlightScheduleCrewData> flightScheduleCrewKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, FlightScheduleCrewData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(flightScheduleCrewConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, FlightScheduleCrewData> flightScheduleCrewConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "flightScheduleCrewData");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(FlightScheduleCrewData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, FlightSchedulePilotData> flightSchedulePilotKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, FlightSchedulePilotData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(flightSchedulePilotConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, FlightSchedulePilotData> flightSchedulePilotConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "flightSchedulePilot");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(FlightSchedulePilotData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, PilotData> pilotKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, PilotData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(pilotConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, PilotData> pilotConsumerFactory() {
		Map<String, Object> props = commonProperty();

		props.put(ConsumerConfig.GROUP_ID_CONFIG, "pilot");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(PilotData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, PilotDesignationData> pilotDesignationKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, PilotDesignationData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(pilotDesignationConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, PilotDesignationData> pilotDesignationConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "pilotDesignation");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(PilotDesignationData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, RestDetailData> restDetailKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, RestDetailData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(restDetailConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, RestDetailData> restDetailConsumerFactory() {
		Map<String, Object> props = commonProperty();
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "restDetail");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(RestDetailData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, UserData> userKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, UserData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsumerFactory<Integer, UserData> userConsumerFactory() {
		Map<String, Object> props = commonProperty();

		props.put(ConsumerConfig.GROUP_ID_CONFIG, "user");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(UserData.class));
	}

}
