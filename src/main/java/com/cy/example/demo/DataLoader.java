package com.example.demo;

import com.cy.example.demo.Role;
import com.cy.example.demo.RoleRepository;
import com.cy.example.demo.User;
import com.cy.example.demo.UserRepository;
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

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role applicantRole = roleRepository.findByRole("APPLICANT");
        Role employerRole = roleRepository.findByRole("EMPLOYER");

        // Add user roles
        User user = new User("bob@burger.com", "password", "Bobby", "Burger", true, "bob");
        user.setRoles(Arrays.asList(employerRole));
        userRepository.save(user);

        user = new User("jane@virgin.com", "password", "Jane", "Virgin", true, "jane");
        user.setRoles(Arrays.asList(applicantRole));
        userRepository.save(user);

        // Add admin roles
        user = new User("admin@secure.com", "password", "Admin", "User", true, "admin");
        user.setRoles(Arrays.asList(applicantRole));
        userRepository.save(user);


    }
}
