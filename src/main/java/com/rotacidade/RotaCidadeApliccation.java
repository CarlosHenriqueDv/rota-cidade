package com.rotacidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class RotaCidadeApliccation {

    public static void main(String[] args) {
        SpringApplication.run(RotaCidadeApliccation.class, args);
    }
}
