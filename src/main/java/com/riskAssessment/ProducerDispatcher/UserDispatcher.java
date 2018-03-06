package com.riskAssessment.ProducerDispatcher;

import javax.validation.constraints.Null;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.ProducerPOJO.PilotDesignation;
import com.riskAssessment.ProducerPOJO.User;

@Service
public class UserDispatcher {
	@Autowired
	private KafkaTemplate<Integer, User> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(User user) {
		try {
			System.out.println(user);
			System.out.println("hii");
			SendResult<Integer, User> sendResult = kafkaTemplate.sendDefault(user.getUserId(), user).get();
			System.out.println("h");
			record.setUserCount(record.getUserCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

			System.out.println("Piyush  " + recordMetadata.offset());
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
