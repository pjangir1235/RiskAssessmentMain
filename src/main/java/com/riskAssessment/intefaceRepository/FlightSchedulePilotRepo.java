package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.FlightSchedulePilot;

@Repository
public interface FlightSchedulePilotRepo extends CrudRepository<FlightSchedulePilot, Long> {

}
