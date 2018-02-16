package com.cy.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String jobTitle;

    @NotNull
    @Size(min=3)
    private String company;

    @NotNull
    @Size(min=1)
    private String serviceYear;

    @NotNull
    @Size(min=3)
    private String duties;


    public Experience() {
        this.jobTitle = "Programmer";
        this.company = "CSC";
        this.serviceYear = "2000";
        this.duties = "development";
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(String serviceYear) {
        this.serviceYear = serviceYear;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
