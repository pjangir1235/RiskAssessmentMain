package com.riskAssessment.intefaceRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.ProducerPOJO.RestDetail;

@Repository
public interface RestDetailRepo extends CrudRepository<RestDetail, Long> {

}
