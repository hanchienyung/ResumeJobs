package com.cy.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Requiredskill {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotNull
        @Size(min = 2)
        private String skillname;

        @ManyToMany(mappedBy = "jobSkills",
                fetch = FetchType.EAGER)
        private List<Job> skillJob;
       // private Set<Job> Jobs;




        public Requiredskill(String skillname) {
                this.skillname = skillname;
        }

        public Requiredskill() {
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getSkillname() {
                return skillname;
        }

        public void setSkillname(String skillname) {
                this.skillname = skillname;
        }

        public List<Job> getSkillJob() {
                return skillJob;
        }

        public void setSkillJob(List<Job> skillJob) {
                this.skillJob = skillJob;
        }

    /*    public void addJob(Job j)
        {
                Jobs.add(j);
        }
        */
}
