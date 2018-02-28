package com.riskAssessment.ProducerDispatcher;

import javax.validation.constraints.Null;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.ProducerPOJO.PilotDesignation;

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

			System.out.println("Piyush  " + recordMetadata.offset());
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
