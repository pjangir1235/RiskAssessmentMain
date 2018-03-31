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

import com.risk.consumer.model.AircraftTypeDTO;
import com.risk.models.StoreRecord;

@Component
public class AircraftTypeListener {

  private static final Logger log = LoggerFactory.getLogger(AircraftTypeListener.class);
  @Autowired StoreRecord record;

  public final CountDownLatch countDownLatch1 = new CountDownLatch(3);

  @KafkaListener(
    topics = "${kafka.topic-aircraftType}",
    containerFactory = "aircraftTypeDataKafkaListenerContainerFactory"
  )
  public void aircraftTypeListner(
      @Payload AircraftTypeDTO schedule,
      @Header(KafkaHeaders.OFFSET) Integer offset,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
      @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
    log.info(
        "Processing topic = {}, partition = {}, offset = {}, workUnit = {}",
        topic,
        partition,
        offset,
        schedule);
    record.setAircraftType(schedule);
    record.setAircraftTypeCount(record.getAircraftTypeCount() - 1);
    countDownLatch1.countDown();
  }
}
