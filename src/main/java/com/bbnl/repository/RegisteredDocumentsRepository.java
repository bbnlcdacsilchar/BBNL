package com.bbnl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbnl.entity.RegisteredDocuments;
@Repository
public interface RegisteredDocumentsRepository extends JpaRepository<RegisteredDocuments, Long>{

}
