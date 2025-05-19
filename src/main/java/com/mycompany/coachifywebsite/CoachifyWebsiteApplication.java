package com.mycompany.coachifywebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.mycompany.coachifywebsite", "io.coachify"})
@EnableMongoRepositories(basePackages = {"com.mycompany.coachifywebsite.Repositories", "io.coachify.entity.repo"})
@EntityScan(basePackages = {"com.mycompany.coachifywebsite.Entities", "io.coachify.entity.model"})
public class CoachifyWebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoachifyWebsiteApplication.class, args);
    }
}