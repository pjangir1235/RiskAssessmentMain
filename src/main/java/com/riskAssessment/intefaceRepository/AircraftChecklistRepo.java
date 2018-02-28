package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.AircraftChecklist;

@Repository
public interface AircraftChecklistRepo extends CrudRepository<AircraftChecklist, Long> {

}
