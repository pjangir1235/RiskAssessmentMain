package com.riskAssessment.producerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllData {
    @Autowired
    private GetAirportData airportData;

    public void getData() {
	airportData.getAirport();

    }
}
