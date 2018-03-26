package com.risk.intefacerepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.risk.producerpojo.RestDetail;

@Repository
public interface RestDetailRepo extends CrudRepository<RestDetail, Long> {

}
