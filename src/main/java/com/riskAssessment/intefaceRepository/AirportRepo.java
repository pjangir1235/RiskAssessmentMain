package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.POJO.Airport_Location;

@Repository
public interface AirportRepo extends CrudRepository<Airport_Location, Long> {

}
