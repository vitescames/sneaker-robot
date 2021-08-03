package br.com.robo.config;

import br.com.robo.adapters.dataprovider.WebPageDataProvider;
import br.com.robo.adapters.entrypoint.controllers.ArtwalkController;
import br.com.robo.adapters.entrypoint.controllers.Controllers;
import br.com.robo.usecases.AbreSite;
import br.com.robo.usecases.ports.AbreSiteCommand;
import br.com.robo.usecases.ports.WebPageGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public AbreSiteCommand abreSiteCommand(){
        return new AbreSite();
    }

    @Bean
    public WebPageGateway webPageGateway(){
        return new WebPageDataProvider();
    }

    @Bean("artwalk")
    public Controllers artwalkController(){
        return new ArtwalkController();
    }

}
