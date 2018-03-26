package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.FlightSchedulePilot;

@Repository
public interface FlightSchedulePilotRepo extends CrudRepository<FlightSchedulePilot, Long> {

}
