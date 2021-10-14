package br.com.robo.config.dataprovider;


import br.com.robo.adapters.dataprovider.ArtwalkGatewayImpl;
import br.com.robo.adapters.dataprovider.service.*;
import br.com.robo.domain.usecases.ProcuraBotaoComprar;
import br.com.robo.domain.ports.ArtwalkWebPageGateway;
import br.com.robo.domain.ports.ProcuraBotaoComprarCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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
