package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ExperienceRepository extends CrudRepository<Experience, Long>{
    List <Experience> findAll() ;
}