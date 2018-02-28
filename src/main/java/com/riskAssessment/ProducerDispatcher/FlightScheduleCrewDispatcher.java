package com.riskAssessment.ProducerDispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.ProducerPOJO.FlightScheduleCrew;

@Service
public class FlightScheduleCrewDispatcher {
	@Autowired
	private KafkaTemplate<Integer, FlightScheduleCrew> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(FlightScheduleCrew craft) {
		try {
			SendResult<Integer, FlightScheduleCrew> sendResult = kafkaTemplate
					.sendDefault(craft.getCrewMemberId(), craft).get();
			record.setFlightScheduleCrewCount(record.getFlightScheduleCrewCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

			System.out.println("Piyush  " + recordMetadata.offset());
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
