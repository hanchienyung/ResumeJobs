package com.cy.example.demo;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String position;


    private String duties;


    @ManyToOne
    private Organization jobOrg;

    @ManyToMany
    private Set<Skill> jobSkills;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public Organization getJobOrg() {
        return jobOrg;
    }

    public void setJobOrg(Organization jobOrg) {
        this.jobOrg = jobOrg;
    }

    public Set<Skill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(Set<Skill> jobSkills) {
        this.jobSkills = jobSkills;
    }

    public void addSkilltoJob(Skill aSkill)
    {
        this.jobSkills.add(aSkill);
    }
}