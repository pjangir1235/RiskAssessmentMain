package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.Airport;

@Repository
public interface AirportRepo extends CrudRepository<Airport, Long> {

}
