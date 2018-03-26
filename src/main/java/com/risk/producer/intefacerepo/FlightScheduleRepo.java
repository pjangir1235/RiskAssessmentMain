package com.risk.intefacerepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.constraint.QuerySql;
import com.risk.producerpojo.FlightSchedule;

@Repository
public interface FlightScheduleRepo extends CrudRepository<FlightSchedule, Long> {
	
	
	@Query(QuerySql.SCHEDULEBYLOCATION)
	 List<FlightSchedule>findSchedule(String location,String date);
		

}
