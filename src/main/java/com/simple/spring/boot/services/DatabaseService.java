package com.simple.spring.boot.services;

import com.simple.spring.boot.entity.Name;
import com.simple.spring.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Component("dbService")
public class DatabaseService {
    //Dependent Injection
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTables() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS PERSON (id INT PRIMARY KEY," +
                "first_name VARCHAR(255),last_name VARCHAR(255),age INT)");
    }
    public void addPerson(Person person) {
        jdbcTemplate.update("INSERT INTO PERSON (id, first_name, last_name, age) VALUES (?, ?, ?, ?)",
                person.getId(), person.getName().getFirstName(), person.getName().getLastName(), person.getAge());
    }

    public List<Person> selectPersonData(){
        return jdbcTemplate.query("SELECT id, first_name, last_name, age FROM PERSON", (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            Name name = new Name();
            name.setFirstName(rs.getString("first_name"));
            name.setLastName(rs.getString("last_name"));
            person.setName(name);
            person.setAge(rs.getInt("age"));
            return person;
        });
    }


}


