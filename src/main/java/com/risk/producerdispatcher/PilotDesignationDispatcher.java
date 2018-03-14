package com.risk.producerdispatcher;

import javax.validation.constraints.Null;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.risk.datastorageconsumer.StoreRecord;
import com.risk.producerpojo.PilotDesignation;

@Service
public class PilotDesignationDispatcher {
	@Autowired
	private KafkaTemplate<Null, PilotDesignation> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(PilotDesignation craft) {
		try {
			SendResult<Null, PilotDesignation> sendResult = kafkaTemplate.sendDefault(null, craft).get();
			record.setPilotDesignationCount(record.getPilotDesignationCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
