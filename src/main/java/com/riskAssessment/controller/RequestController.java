package com.riskAssessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riskAssessment.ConsumerPOJO.Airport_Data;
import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.producerService.GetAllData;

@Controller
@RequestMapping
public class RequestController {

	@Autowired
	GetAllData getAllData;

	@Autowired
	StoreRecord record;

	@GetMapping("/aircraftDetail")
	@ResponseBody
	public List<Airport_Data> getAllAircraft() {
		try {
			getAllData.getData();
			while (record.getAirportCount() != 0) {
				System.out.println("record" + record.getAirportCount());
				Thread.sleep(300);
			}
			return record.getAirport();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

}

// SingletonEnum singleton = SingletonEnum.INSTANCE;