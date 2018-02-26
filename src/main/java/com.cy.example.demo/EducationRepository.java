package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EducationRepository extends CrudRepository<Education, Long>{
    List <Education> findAll() ;
}