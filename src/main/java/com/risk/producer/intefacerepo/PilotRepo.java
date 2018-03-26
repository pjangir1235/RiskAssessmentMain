package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.Pilot;

@Repository
public interface PilotRepo extends CrudRepository<Pilot, Long> {

}
