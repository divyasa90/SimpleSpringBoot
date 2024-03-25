package com.simple.spring.boot.controller;

import com.simple.spring.boot.entity.Person;
import com.simple.spring.boot.services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    DatabaseService dbService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!..How are you..";
    }

    @GetMapping("/createTables")
    public String createTables() {
        dbService.createTables();
        return "Created Person Table..";
    }
    @PostMapping("/addPerson")
    public String addPerson(@RequestBody Person person){
        try {
            dbService.addPerson(person);
            return "Person Added";
        } catch (Exception e) {
            return "Error adding person: " + e.getMessage();
        }
    }

    @GetMapping("/selectPersonData")
    public ResponseEntity<?> selectPersonData(){
        try {
            List<Person> persons = dbService.selectPersonData();
            if(persons.isEmpty()){
                return new ResponseEntity<>("No data found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

