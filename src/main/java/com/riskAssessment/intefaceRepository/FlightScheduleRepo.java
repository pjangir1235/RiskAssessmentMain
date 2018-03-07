package com.riskAssessment.intefaceRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riskAssessment.Constraint.QuerySql;
import com.riskAssessment.ProducerPOJO.FlightSchedule;

@Repository
public interface FlightScheduleRepo extends CrudRepository<FlightSchedule, Long> {
	
	
	@Query(QuerySql.SCHEDULEBYLOCATION)
	 List<FlightSchedule>findSchedule(String location,String date);
		

}
