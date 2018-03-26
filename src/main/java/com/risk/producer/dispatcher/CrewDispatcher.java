package com.risk.producerdispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.risk.datastorageconsumer.StoreRecord;
import com.risk.producerpojo.Crew;

@Service
public class CrewDispatcher {
	@Autowired
	private KafkaTemplate<Integer, Crew> kafkaTemplate;

	@Autowired
	StoreRecord record;
	 private static final Logger log =LoggerFactory.getLogger(CrewDispatcher.class);

	public boolean dispatch(Crew craft) {
		try {
			SendResult<Integer, Crew> sendResult = kafkaTemplate.sendDefault(craft.getCrewMemberId(), craft).get();
			record.setCrewCount(record.getCrewCount() + 1);
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
