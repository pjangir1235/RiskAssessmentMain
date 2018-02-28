package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.FlightSchedule;

@Repository
public interface FlightScheduleRepo extends CrudRepository<FlightSchedule, Long> {

}
