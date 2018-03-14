package com.risk.producerdispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.risk.datastorageconsumer.StoreRecord;
import com.risk.producerpojo.RestDetail;

@Service
public class RestDetailDispatcher {
	@Autowired
	private KafkaTemplate<Integer, RestDetail> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(RestDetail craft) {
		try {
			SendResult<Integer, RestDetail> sendResult = kafkaTemplate.sendDefault(craft.getMemberId(), craft).get();
			record.setRestDetailCount(record.getRestDetailCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
