package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.Aircraft;

@Repository
public interface AircraftRepo extends CrudRepository<Aircraft, Long> {

}
