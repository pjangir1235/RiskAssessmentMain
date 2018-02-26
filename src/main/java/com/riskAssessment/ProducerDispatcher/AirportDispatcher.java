package com.riskAssessment.ProducerDispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.ProducerPOJO.AirportLocation;

@Service
public class AirportDispatcher {
	@Autowired
	private KafkaTemplate<Integer, AirportLocation> aircraftKafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(AirportLocation craft) {
		try {

			SendResult<Integer, AirportLocation> sendResult = aircraftKafkaTemplate
					.sendDefault(craft.getAirportId(), craft).get();
			record.setAirportCount(record.getAirportCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();
			System.out.println("Piyush  " + recordMetadata.offset());
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
