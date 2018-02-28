package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.Crew;

@Repository
public interface CrewRepo extends CrudRepository<Crew, Long> {

}
