package com.kai.wang.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kai.wang.spring.data.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {
	
}
