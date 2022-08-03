package com.bbnl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbnl.entity.Demand;

public interface DemandRepository extends JpaRepository<Demand, Integer> {

}
