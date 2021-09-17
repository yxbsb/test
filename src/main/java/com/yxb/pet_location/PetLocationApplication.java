package com.yxb.pet_location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PetLocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetLocationApplication.class, args);
    }

}
