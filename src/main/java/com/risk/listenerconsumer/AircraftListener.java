package com.risk.listenerconsumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.risk.consumerpojo.AircraftData;
import com.risk.datastorageconsumer.StoreRecord;

@Component
public class AircraftListener {

	@Autowired
	StoreRecord record;
	public final CountDownLatch countDownLatch1 = new CountDownLatch(3);

	private static final Logger log = LoggerFactory.getLogger(AircraftListener.class);

	@KafkaListener(topics = "${kafka.topic-aircraft}", containerFactory = "aircraftKafkaListenerContainerFactory")

	public void aircraftListner(@Payload AircraftData schedule, @Header(KafkaHeaders.OFFSET) Integer offset,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
		log.info("Processing topic = {}, partition = {}, offset = {}, workUnit = {}", topic, partition, offset,
				schedule);
		record.setAircraft(schedule);
		record.setAircraftCount(record.getAircraftCount() - 1);
		countDownLatch1.countDown();

	}

}
