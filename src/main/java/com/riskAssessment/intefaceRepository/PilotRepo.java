package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.Pilot;

@Repository
public interface PilotRepo extends CrudRepository<Pilot, Long> {

}
