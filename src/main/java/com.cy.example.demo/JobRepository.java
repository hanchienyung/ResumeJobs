package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {
        List<Job> findAll() ;
        Job findJobById(Long id);


}
