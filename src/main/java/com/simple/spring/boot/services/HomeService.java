package com.simple.spring.boot.services;

import com.opencsv.CSVReader;
import com.simple.spring.boot.entity.Home;
import com.simple.spring.boot.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Service("homeService")
public class HomeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createHomeTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS HOME (id INT PRIMARY KEY," +
                "address VARCHAR(255),sell INT,list INT,living INT,rooms INT,beds INT," +
                "baths INT,age INT,acres INT,taxes INT)");
    }

// #tolearn
    @Transactional
    public void readAndSaveHomes(String csvFilePath) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;
            // Skip header line if present: reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Home home = new Home();
                home.setId(Integer.parseInt(nextLine[0]));
                home.setAddress(nextLine[1]);
                home.setSell(Integer.parseInt(nextLine[2]));
                home.setList(Integer.parseInt(nextLine[3]));
                home.setLiving(Integer.parseInt(nextLine[4]));
                home.setRooms(Integer.parseInt(nextLine[5]));
                home.setBeds(Integer.parseInt(nextLine[6]));
                home.setBaths(Integer.parseInt(nextLine[7]));
                home.setAge(Integer.parseInt(nextLine[8]));
                home.setAcres(Integer.parseInt(nextLine[9]));
                home.setTaxes(Integer.parseInt(nextLine[10]));
                jdbcTemplate.update("INSERT INTO HOME (id, address, sell, list, living, rooms, beds, baths," +
                                " age, acres, taxes) VALUES (?, ?, ?)", Integer.parseInt(nextLine[0]), nextLine[1],
                        Integer.parseInt(nextLine[2]), Integer.parseInt(nextLine[3]), Integer.parseInt(nextLine[4]),
                        Integer.parseInt(nextLine[5]), Integer.parseInt(nextLine[6]), Integer.parseInt(nextLine[7]),
                        Integer.parseInt(nextLine[8]), Integer.parseInt(nextLine[9]), Integer.parseInt(nextLine[10]));

            }
        }
    }

    public void readHomeTable() {
        jdbcTemplate.execute("SELECT * FROM HOME");
    }
}

