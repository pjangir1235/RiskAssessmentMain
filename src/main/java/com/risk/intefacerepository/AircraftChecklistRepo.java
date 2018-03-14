package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.AircraftChecklist;

@Repository
public interface AircraftChecklistRepo extends CrudRepository<AircraftChecklist, Long> {

}
