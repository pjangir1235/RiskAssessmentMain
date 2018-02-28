package com.riskAssessment.Listener;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.riskAssessment.ConsumerPOJO.FlightSchedulePilotData;
import com.riskAssessment.DataStorageConsumerr.StoreRecord;

@Component
public class FlightSchedulePilotListener {

	@Autowired
	StoreRecord record;
	public final CountDownLatch countDownLatch1 = new CountDownLatch(3);

	private static final Logger log = LoggerFactory.getLogger(FlightSchedulePilotListener.class);

	@KafkaListener(topics = "${kafka.topic-flightSchedulePilot}", containerFactory = "flightSchedulePilotKafkaListenerContainerFactory")

	public void flightSchedulePilot6Listner(@Payload FlightSchedulePilotData schedule,
			@Header(KafkaHeaders.OFFSET) Integer offset, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
		System.out.println("Hii");
		log.info("Processing topic = {}, partition = {}, offset = {}, workUnit = {}", topic, partition, offset,
				schedule);
		record.setFlightSchedulePilot(schedule);
		record.setFlightSchedulePilotCount(record.getFlightSchedulePilotCount() - 1);
		countDownLatch1.countDown();

	}

}
