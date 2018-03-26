package com.risk.constraint;

import org.springframework.beans.factory.annotation.Autowired;

public class QuerySql {
	@Autowired
	SqlConstraint sql;
	private QuerySql() {

	}

	public static final String USERBYID= SqlConstraint.SELECT+"user "+SqlConstraint.FROM+"User user "+SqlConstraint.WHERE+"user.userName=?1 "+
								  SqlConstraint.AND+"user."+SqlConstraint.PASS+SqlConstraint.WORD+"=?2";
	public static final String SCHEDULEBYLOCATION=SqlConstraint.SELECT+"flight "+SqlConstraint.FROM+"FlightSchedule flight "+
								  SqlConstraint.WHERE+"flight.sourceAirportCode=?1 "+ SqlConstraint.AND+"flight.dateOfDeparture=?2";


}
