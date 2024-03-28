package com.simple.spring.boot.controller;

import com.simple.spring.boot.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/createHomeTable")
    public String createHomeTable() {
        try{
        homeService.createHomeTable();
        return "Created Home Table..";
        } catch(Exception e){
            return"cannot create table";
        }
    }
    @GetMapping("/addHomeData")
    public ResponseEntity<String> addHomeData() {
        try {
            homeService.readAndSaveHomes("/Users/sriram/Documents/Divya/Study/Java/sheets/homes.csv");
            return new ResponseEntity<>("Homes loaded successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to load homes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

