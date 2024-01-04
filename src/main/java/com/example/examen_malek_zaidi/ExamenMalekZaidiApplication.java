package com.example.examen_malek_zaidi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
public class ExamenMalekZaidiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenMalekZaidiApplication.class, args);
    }

}