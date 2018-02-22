package com.riskAssessment.producerService;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.riskAssessment.POJO.Airport_Location;

@Service
public class AirportDispatcher {
    @Autowired
    private KafkaTemplate<Integer, Airport_Location> aircraftKafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(AirportDispatcher.class);

    public boolean dispatch(Airport_Location craft) {
	try {

	    SendResult<Integer, Airport_Location> sendResult = aircraftKafkaTemplate
		    .sendDefault(craft.getAirportId(), craft).get();
	    RecordMetadata recordMetadata = sendResult.getRecordMetadata();
	    return true;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

}
