package com.riskAssessment.ProducerDispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.ProducerPOJO.FlightSchedulePilot;

@Service
public class FlightSchedulePilotDispatcher {
	@Autowired
	private KafkaTemplate<Integer, FlightSchedulePilot> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(FlightSchedulePilot craft) {
		try {
			SendResult<Integer, FlightSchedulePilot> sendResult = kafkaTemplate
					.sendDefault(craft.getFlightScheduleId(), craft).get();
			record.setFlightSchedulePilotCount(record.getFlightSchedulePilotCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

			System.out.println("Piyush  " + recordMetadata.offset());
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
