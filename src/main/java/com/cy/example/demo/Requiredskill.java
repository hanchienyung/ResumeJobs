package com.cy.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Requiredskill {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotNull
        @Size(min = 2)
        private String skillname;

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
}
