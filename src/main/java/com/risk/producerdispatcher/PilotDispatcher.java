package com.risk.producerdispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.risk.datastorageconsumer.StoreRecord;
import com.risk.producerpojo.Pilot;

@Service
public class PilotDispatcher {
	@Autowired
	private KafkaTemplate<Integer, Pilot> kafkaTemplate;

	@Autowired
	StoreRecord record;
	 private static final Logger log =
	 LoggerFactory.getLogger(PilotDispatcher.class);

	public boolean dispatch(Pilot craft) {
		try {
			SendResult<Integer, Pilot> sendResult = kafkaTemplate.sendDefault(craft.getPilotId(), craft).get();
			record.setPilotCount(record.getPilotCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();
			String metaRecord="{offset - "+recordMetadata.offset()+" partition - "+recordMetadata.partition()+" TimeStamp - "+recordMetadata.timestamp()+" }";
			log.info(metaRecord);
			return true;
		} catch (Exception e) {
			log.error(" "+e);
			return false;
		}
	}

}
