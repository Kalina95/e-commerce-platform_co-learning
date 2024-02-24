package com.ecommerce.contentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ContentServiceApplication {

    //sudo kill -9 $(lsof -ti:8082)

    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApplication.class, args);
    }
}


