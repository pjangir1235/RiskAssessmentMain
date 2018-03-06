package com.riskAssessment.ConsumerConfiguration;

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

import com.riskAssessment.ConsumerPOJO.AircraftChecklistData;
import com.riskAssessment.ConsumerPOJO.AircraftData;
import com.riskAssessment.ConsumerPOJO.AircraftTypeData;
import com.riskAssessment.ConsumerPOJO.AirportData;
import com.riskAssessment.ConsumerPOJO.CrewData;
import com.riskAssessment.ConsumerPOJO.FlightScheduleCrewData;
import com.riskAssessment.ConsumerPOJO.FlightScheduleData;
import com.riskAssessment.ConsumerPOJO.FlightSchedulePilotData;
import com.riskAssessment.ConsumerPOJO.PilotData;
import com.riskAssessment.ConsumerPOJO.PilotDesignationData;
import com.riskAssessment.ConsumerPOJO.RestDetailData;
import com.riskAssessment.ConsumerPOJO.UserData;
import com.riskAssessment.DataStorageConsumerr.StoreRecord;

@Configuration
@EnableKafka
public class ConsumerCommonConfig {

	@Value("${kafka.bootstrap}")
	private String bootstrap;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AirportData> airportKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AirportData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(airportConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, AirportData> airportConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "airport");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(AirportData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AircraftData> aircraftKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AircraftData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(aircraftConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, AircraftData> aircraftConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "aircraft");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(AircraftData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AircraftChecklistData> aircraftChecklistKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AircraftChecklistData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(aircraftChecklistConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, AircraftChecklistData> aircraftChecklistConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "aircraftChecklist");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(AircraftChecklistData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, AircraftTypeData> aircraftTypeDataKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, AircraftTypeData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(aircraftTypeDataConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, AircraftTypeData> aircraftTypeDataConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "aircraftTypeData");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(AircraftTypeData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, CrewData> crewDataKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, CrewData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(crewDataConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, CrewData> crewDataConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "crew");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(CrewData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, FlightScheduleData> flightScheduleKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, FlightScheduleData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(flightScheduleConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, FlightScheduleData> flightScheduleConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "flightSchedule");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(FlightScheduleData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, FlightScheduleCrewData> flightScheduleCrewKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, FlightScheduleCrewData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(flightScheduleCrewConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, FlightScheduleCrewData> flightScheduleCrewConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "flightScheduleCrewData");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(FlightScheduleCrewData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, FlightSchedulePilotData> flightSchedulePilotKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, FlightSchedulePilotData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(flightSchedulePilotConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, FlightSchedulePilotData> flightSchedulePilotConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "flightSchedulePilot");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(FlightSchedulePilotData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, PilotData> pilotKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, PilotData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(pilotConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, PilotData> pilotConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "pilot");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(PilotData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, PilotDesignationData> pilotDesignationKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, PilotDesignationData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(pilotDesignationConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, PilotDesignationData> pilotDesignationConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "pilotDesignation");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(PilotDesignationData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, RestDetailData> restDetailKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, RestDetailData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(restDetailConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, RestDetailData> restDetailConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "restDetail");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(RestDetailData.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, UserData> userKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, UserData> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}

	public ConsumerFactory<Integer, UserData> userConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "user");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		props.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, "100");
		return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(),
				new JsonDeserializer(UserData.class));
	}
	

	

}
