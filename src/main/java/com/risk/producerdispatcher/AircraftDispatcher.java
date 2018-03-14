package com.risk.producerdispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.risk.datastorageconsumer.StoreRecord;
import com.risk.producerpojo.Aircraft;

@Service
public class AircraftDispatcher {
	@Autowired
	private KafkaTemplate<Integer, Aircraft> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(Aircraft craft) {
		try {
			SendResult<Integer, Aircraft> sendResult = kafkaTemplate.sendDefault(craft.getAircraftId(), craft).get();
			record.setAircraftCount(record.getAircraftCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
