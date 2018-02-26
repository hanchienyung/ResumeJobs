package com.cy.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String orgName;

    @OneToMany
    private Set<Job> orgJob;

    public Organization() {
    }

    public Organization(String orgName) {
        this.orgName = orgName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

}
