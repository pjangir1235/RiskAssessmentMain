package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.Aircraft;

@Repository
public interface AircraftRepo extends CrudRepository<Aircraft, Long> {

}
