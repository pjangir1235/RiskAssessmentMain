package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.FlightScheduleCrew;

@Repository
public interface FlightScheduleCrewRepo extends CrudRepository<FlightScheduleCrew, Long> {

}
