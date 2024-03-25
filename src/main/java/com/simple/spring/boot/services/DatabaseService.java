package com.simple.spring.boot.services;

import com.simple.spring.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component("dbService")
public class DatabaseService {
    //Dependent Injection
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTables() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS PERSON (id INT PRIMARY KEY," +
                "first name VARCHAR(255),last name VARCHAR(255),age INT)");
    }
    public void addPerson(Person person) {
        jdbcTemplate.update("INSERT INTO PERSON (id, \"first name\", \"last name\", age) VALUES (?, ?, ?, ?)",
                person.getId(), person.getName().getFirstName(), person.getName().getLastName(), person.getAge());
    }

    public void selectPersonData(){
        jdbcTemplate.execute("SELECT * FROM PERSON");
    }
}


