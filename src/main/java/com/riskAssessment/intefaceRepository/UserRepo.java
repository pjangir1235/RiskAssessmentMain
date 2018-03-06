package com.riskAssessment.intefaceRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riskAssessment.Constraint.QuerySql;
import com.riskAssessment.ProducerPOJO.PilotDesignation;
import com.riskAssessment.ProducerPOJO.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	
	
	@Query(QuerySql.USERBYID)
	List<User> findByName(String userName,String password);

}
