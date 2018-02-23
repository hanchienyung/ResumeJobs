package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {
        List<Job> findAll() ;
        List<Job> findByOrganization(String org) ;
        Job findJobById(Long id);


}
