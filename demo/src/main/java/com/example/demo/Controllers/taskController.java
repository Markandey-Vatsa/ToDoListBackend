package com.example.demo.Controllers;

import com.example.demo.Repository.Repository;
import com.example.demo.Repository.personRepo;
import com.example.demo.entity.Task;
import com.example.demo.entity.person;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class taskController {

    @Autowired
    Repository mongorepo;

    @Autowired
    personRepo user_person;


    @PostMapping("/addList")
    ResponseEntity<?> addToList(@RequestBody Task task){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        System.out.println(username);

        person user = user_person.findByUserName(username);

        mongorepo.save(task);
        user.getGetTasks().add(task);
        user_person.save(user);

        return new ResponseEntity<>("Task Added Successfully",HttpStatus.OK);
    }


    @GetMapping("/getTask/{title}")
    ResponseEntity<?> getTask(@PathVariable String title){
        Task t = mongorepo.findByTitle(title);
        if(t!=null){
            return new ResponseEntity<>(t,HttpStatus.OK);
        }
        return new ResponseEntity<>("Task not found !!",HttpStatus.NOT_FOUND);
    }


}
