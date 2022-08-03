package com.bbnl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbnl.entity.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {

}
