package br.com.robo.adapters.dataprovider.gateway.artwalkintegration.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DriverConfig {

    @Value("${driver.location}")
    private String driverLocation;

    @PostConstruct
    public void setDriverLocation(){
        System.setProperty("webdriver.gecko.driver", driverLocation);
    }

}
