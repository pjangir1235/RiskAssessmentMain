package com.riskAssessment.Listener;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.riskAssessment.ConsumerPOJO.Airport_Data;
import com.riskAssessment.DataStorageConsumerr.StoreRecord;

@Component
public class AirportListener {

	@Autowired
	StoreRecord record;
	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	private static final Logger log = LoggerFactory.getLogger(AirportListener.class);

	@KafkaListener(topics = "risk_airport")
	public void flightScheduleListner(Airport_Data schedule, @Header(KafkaHeaders.OFFSET) Integer offset,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
		log.info("Processing topic = {}, partition = {}, offset = {}, workUnit = {}", topic, partition, offset,
				schedule);
		record.setAirportObj(schedule);
		System.out.println("jangir " + offset);
		record.setAirportCount(record.getAirportCount() - 1);
		System.out.println(schedule.toString());
		countDownLatch1.countDown();

	}

}
