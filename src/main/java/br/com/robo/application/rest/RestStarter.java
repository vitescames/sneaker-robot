package br.com.robo.application.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.robo.adapters,br.com.robo.core,br.com.robo.application.rest")
public class RestStarter {
    public static void main(String[] args) {
        SpringApplication.run(RestStarter.class, args);
    }
}
