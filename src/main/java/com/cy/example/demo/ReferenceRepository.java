package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReferenceRepository extends CrudRepository<Reference, Long>{
    List <Reference> findAll() ;
}