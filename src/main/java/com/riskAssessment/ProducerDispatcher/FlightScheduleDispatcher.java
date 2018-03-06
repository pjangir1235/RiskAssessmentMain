package com.riskAssessment.ProducerDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.ProducerPOJO.FlightSchedule;

@Service
public class FlightScheduleDispatcher {
	@Autowired
	private KafkaTemplate<Integer, FlightSchedule> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(FlightSchedule craft) {
		
		System.out.println(craft.toString());
		return true;
//		try {
//			SendResult<Integer, FlightSchedule> sendResult = kafkaTemplate
//					.sendDefault(craft.getFlightScheduleId(), craft).get();
//			record.setFlightScheduleCount(record.getFlightScheduleCount() + 1);
//			RecordMetadata recordMetadata = sendResult.getRecordMetadata();
//
//			System.out.println("Piyush  " + recordMetadata.offset() + "  " + recordMetadata);
//			return true;
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
	}

}
