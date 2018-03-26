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

import com.risk.consumer.model.RestDetailDTO;
import com.risk.models.StoreRecord;

@Component
public class RestDetailListener {

	private static final Logger log = LoggerFactory.getLogger(RestDetailListener.class);
	@Autowired
	StoreRecord record;

	public final CountDownLatch countDownLatch1 = new CountDownLatch(3);

	@KafkaListener(topics = "${kafka.topic-restDetail}", containerFactory = "restDetailKafkaListenerContainerFactory")

	public void restDetailListner(@Payload RestDetailDTO schedule, @Header(KafkaHeaders.OFFSET) Integer offset,
	                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
	                @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
		log.info("Processing topic = {}, partition = {}, offset = {}, workUnit = {}", topic, partition, offset,
		                schedule);
		record.setRestDetail(schedule);
		record.setRestDetailCount(record.getRestDetailCount() - 1);
		countDownLatch1.countDown();

	}

}
