package com.riskAssessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riskAssessment.POJO.Airport_Location;
import com.riskAssessment.producerService.GetAllData;

@Controller
@RequestMapping
public class RequestController {

    @Autowired
    GetAllData getAllData;

    @GetMapping("/aircraftDetail")
    @ResponseBody
    public List<Airport_Location> getAllAircraft() {
	getAllData.getData();
	return null;

    }

}
