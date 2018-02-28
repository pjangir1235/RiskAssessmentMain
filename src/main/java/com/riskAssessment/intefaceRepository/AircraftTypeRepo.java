package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.AircraftType;

@Repository
public interface AircraftTypeRepo extends CrudRepository<AircraftType, Long> {

}
