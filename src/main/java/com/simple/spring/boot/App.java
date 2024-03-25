package com.simple.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) /*{
        SpringApplication.run(App.class, args);
    }*/
        {
//           kill $(lsof -t -i:8080)
            SpringApplication app = new SpringApplication(App.class);
            app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
            app.run(args);
        }

}
