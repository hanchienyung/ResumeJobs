package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    SkillRepository skillRepository;


    //@Autowired
    //RequiredskillRepository requiredskillRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");

        roleRepository.save(new Role("APPLICANT"));
        roleRepository.save(new Role("EMPLOYER"));
        roleRepository.save(new Role("RECRUITER"));

        Role applicantRole = roleRepository.findByRole("APPLICANT");
        Role employerRole = roleRepository.findByRole("EMPLOYER");
        Role recruiterRole = roleRepository.findByRole("RECRUITER");

        // Add user roles
        User user = new User("bob@burger.com", "password", "Bobby", "Burger", true, "employer");
        user.setRoles(Arrays.asList(employerRole));
        userRepository.save(user);

        user = new User("jane@virgin.com", "password", "Jane", "Virgin", true, "applicant");
        user.setRoles(Arrays.asList(applicantRole));
        userRepository.save(user);

        user = new User("mike@smith.com", "password", "Mike", "Smith", true, "recruiter");
        user.setRoles(Arrays.asList(recruiterRole));
        userRepository.save(user);

        Organization org1 = new Organization("AAA");
        Organization org2 = new Organization("AARP");
        Organization org3 = new Organization("BARNES");

        organizationRepository.save(org1);
        organizationRepository.save(org2);
        organizationRepository.save(org3);

        Job job1 = new Job();
        job1.setPosition("leader");
        job1.setDuties("program");
        job1.setJobOrg(org1);


        Job job2 = new Job();
        job2.setPosition("leader2");
        job2.setDuties("program2");
        job2.setJobOrg(org2);

        Skill skill1 = new Skill();
        skill1.setRating("familiar");
        skill1.setSkillname("Java");
        skillRepository.save(skill1);
       // user.addSkill(skill1);

        Skill skill2 = new Skill();
        skill2.setRating("good");
        skill2.setSkillname("Oracle");
        skillRepository.save(skill2);
        //user.addSkill(skill2;





     /*   Requiredskill requiredskill1 = new Requiredskill("reqskill1");
        Requiredskill requiredskill2 = new Requiredskill("reqskill2");
        Requiredskill requiredskill3 = new Requiredskill("reqskill3");

        requiredskillRepository.save(requiredskill1);
        requiredskillRepository.save(requiredskill2);
        requiredskillRepository.save(requiredskill3);

        job1.addRequiredSkill(requiredskill1);
        job1.addRequiredSkill(requiredskill2);
        job2.addRequiredSkill(requiredskill3);
        */



        jobRepository.save(job1);
        jobRepository.save(job2);




    }
}
