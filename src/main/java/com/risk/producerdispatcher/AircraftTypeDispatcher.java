package com.risk.producerdispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.risk.datastorageconsumer.StoreRecord;
import com.risk.producerpojo.AircraftType;

@Service
public class AircraftTypeDispatcher {
	@Autowired
	private KafkaTemplate<Integer, AircraftType> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(AircraftType craft) {
		try {
			SendResult<Integer, AircraftType> sendResult = kafkaTemplate.sendDefault(craft.getAircraftTypeId(), craft)
					.get();
			record.setAircraftTypeCount(record.getAircraftTypeCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

				return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
