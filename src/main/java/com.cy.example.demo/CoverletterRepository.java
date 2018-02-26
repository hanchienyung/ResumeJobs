package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CoverletterRepository extends CrudRepository<Coverletter, Long>{
    List <Coverletter> findAll() ;
}