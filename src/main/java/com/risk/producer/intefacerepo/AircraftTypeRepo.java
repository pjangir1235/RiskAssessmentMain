package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.AircraftTypeValue;

@Repository
public interface AircraftTypeRepo extends CrudRepository<AircraftTypeValue, Long> {

}
