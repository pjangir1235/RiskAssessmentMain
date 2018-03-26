package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.FlightScheduleCrew;

@Repository
public interface FlightScheduleCrewRepo extends CrudRepository<FlightScheduleCrew, Long> {

}
