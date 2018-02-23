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

    @NotNull
    @Size(min = 2)
    private String position;

    @NotNull
    @Size(min = 2)
    private String duties;

    @NotNull
    @Size(min = 2)
    private String organization;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Requiredskill> requiredskills;


    public Job() {
        this.requiredskills = new ArrayList<>();
    }


    public Job(String organization) {
        this.organization = organization;
    }

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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public List<Requiredskill> getRequiredskills() {
        return requiredskills;
    }

    public void setRequiredskills(List<Requiredskill> requiredskills) {
        this.requiredskills = requiredskills;
    }

    public void addRequiredSkill(Requiredskill rs)
    { this.requiredskills.add(rs);}
}