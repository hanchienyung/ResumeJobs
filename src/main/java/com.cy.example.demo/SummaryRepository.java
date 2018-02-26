package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SummaryRepository extends CrudRepository<Summary, Long>{
    List <Summary> findAll() ;
}