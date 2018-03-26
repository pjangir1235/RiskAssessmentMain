package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.Crew;

@Repository
public interface CrewRepo extends CrudRepository<Crew, Long> {

}
