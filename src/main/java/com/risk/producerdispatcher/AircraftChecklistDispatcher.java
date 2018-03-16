package com.risk.producerdispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 private static final Logger log =
	 LoggerFactory.getLogger(AircraftChecklistDispatcher.class);

	public boolean dispatch(AircraftChecklist craft) {
		try {
			SendResult<Integer, AircraftChecklist> sendResult = kafkaTemplate.sendDefault(craft.getChecklistId(), craft)
					.get();
			record.setAircraftChecklistCount(record.getAircraftChecklistCount() + 1);
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
