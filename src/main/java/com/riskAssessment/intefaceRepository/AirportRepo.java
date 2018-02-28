package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.Airport;

@Repository
public interface AirportRepo extends CrudRepository<Airport, Long> {

}
