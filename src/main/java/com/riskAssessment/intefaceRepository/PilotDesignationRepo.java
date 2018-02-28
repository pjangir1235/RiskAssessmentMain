package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.PilotDesignation;

@Repository
public interface PilotDesignationRepo extends CrudRepository<PilotDesignation, Long> {

}
