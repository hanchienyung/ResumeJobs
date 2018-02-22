package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequiredskillRepository extends CrudRepository<Requiredskill, Long> {
        List<Requiredskill> findBySkillname(String skillname) ;

}
