package com.riskAssessment.ProducerDispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.ProducerPOJO.Crew;

@Service
public class CrewDispatcher {
	@Autowired
	private KafkaTemplate<Integer, Crew> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(Crew craft) {
		try {
			SendResult<Integer, Crew> sendResult = kafkaTemplate.sendDefault(craft.getCrewMemberId(), craft).get();
			record.setCrewCount(record.getCrewCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
