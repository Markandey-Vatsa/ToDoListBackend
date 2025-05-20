package com.example.demo.Controllers;

import com.example.demo.Repository.personRepo;
import com.example.demo.entity.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class publicController {
    @Autowired
    private personRepo personRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/account-create")
    public ResponseEntity<?> accountCreation(@RequestBody person personEntry) {
        // Encode password before saving
        personEntry.setPassword(passwordEncoder.encode(personEntry.getPassword()));

        // Save the person entity
        person savedPerson = personRepo.save(personEntry);

        // Return success response with saved entity or id
        return new ResponseEntity<>("Saved",HttpStatus.OK);
    }


}
