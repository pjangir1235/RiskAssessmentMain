package com.risk.producerdispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.risk.datastorageconsumer.StoreRecord;
import com.risk.producerpojo.AircraftChecklist;

@Service
public class AircraftChecklistDispatcher {
	@Autowired
	private KafkaTemplate<Integer, AircraftChecklist> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(AircraftChecklist craft) {
		try {
			SendResult<Integer, AircraftChecklist> sendResult = kafkaTemplate.sendDefault(craft.getChecklistId(), craft)
					.get();
			record.setAircraftChecklistCount(record.getAircraftChecklistCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

				return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
