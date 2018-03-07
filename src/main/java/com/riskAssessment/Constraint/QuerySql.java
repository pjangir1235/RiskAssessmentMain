package com.riskAssessment.Constraint;

import org.springframework.beans.factory.annotation.Autowired;

public class QuerySql {
	@Autowired
	SqlConstraint sql;
	
	public static final String USERBYID= SqlConstraint.SELECT+"user "+SqlConstraint.FROM+"User user "+SqlConstraint.WHERE+"user.userName=?1 "+
								  SqlConstraint.AND+"user.password=?2";
	public static final String SCHEDULEBYLOCATION=SqlConstraint.SELECT+"flight "+SqlConstraint.FROM+"FlightSchedule flight "+
								  SqlConstraint.WHERE+"flight.sourceAirportCode=?1 "+ SqlConstraint.AND+"flight.dateOfDeparture=?2";
	

}
