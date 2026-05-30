package com.example.desafio_itau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class DesafioItauApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioItauApplication.class, args);
    }

}
