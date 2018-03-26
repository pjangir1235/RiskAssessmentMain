package com.risk.consumer.listeners;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.risk.consumer.model.AircraftChecklistDTO;
import com.risk.models.StoreRecord;

@Component
public class AircraftChecklistListener {

	private static final Logger log = LoggerFactory.getLogger(AircraftChecklistListener.class);
	@Autowired
	StoreRecord record;

	public final CountDownLatch countDownLatch1 = new CountDownLatch(3);

	@KafkaListener(topics = "${kafka.topic-aircraftChecklist}", containerFactory = "aircraftChecklistKafkaListenerContainerFactory")

	public void aircraftChecklistListner(@Payload AircraftChecklistDTO schedule,
	                @Header(KafkaHeaders.OFFSET) Integer offset,
	                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
	                @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
		log.info("Processing topic = {}, partition = {}, offset = {}, workUnit = {}", topic, partition, offset,
		                schedule);
		record.setAircraftChecklist(schedule);
		record.setAircraftChecklistCount(record.getAircraftChecklistCount() - 1);
		countDownLatch1.countDown();

	}

}
