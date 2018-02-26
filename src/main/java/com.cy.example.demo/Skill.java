package com.cy.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    private String skillname;

    @NotNull
    @Size(min=1)
    private String rating;

    @ManyToMany(mappedBy="mySkills")
    private List<User> people;

    @ManyToMany(mappedBy="jobSkills")
    private List<Job> requiredskills;

    public Skill() {
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getPeople() {
        return people;
    }

    public void setPeople(List<User> people) {
        this.people = people;
    }

    public void setRequiredskills(List<Job> requiredskills) {
        this.requiredskills = requiredskills;
    }

    public List<Job> getRequiredskills() {
        return requiredskills;
    }
}
