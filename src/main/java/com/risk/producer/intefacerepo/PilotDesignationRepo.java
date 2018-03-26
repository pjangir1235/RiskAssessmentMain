package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.PilotDesignation;

@Repository
public interface PilotDesignationRepo extends CrudRepository<PilotDesignation, Long> {

}
