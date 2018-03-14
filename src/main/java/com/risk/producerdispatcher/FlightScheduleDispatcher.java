package com.risk.producerdispatcher;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.risk.datastorageconsumer.StoreRecord;
import com.risk.producerpojo.FlightSchedule;

@Service
public class FlightScheduleDispatcher {
	@Autowired
	private KafkaTemplate<Integer, FlightSchedule> kafkaTemplate;

	@Autowired
	StoreRecord record;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AirportDispatcher.class);

	public boolean dispatch(FlightSchedule craft) {

		System.out.println(craft.toString());

		try {
			SendResult<Integer, FlightSchedule> sendResult = kafkaTemplate
					.sendDefault(craft.getFlightScheduleId(), craft).get();
			record.setFlightScheduleCount(record.getFlightScheduleCount() + 1);
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();

			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}