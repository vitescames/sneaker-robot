package br.com.robo.adapters.entrypoint.cli.config;

import br.com.robo.adapters.entrypoint.cli.config.ControllerConfig;
import br.com.robo.adapters.entrypoint.controllers.ControllerInterface;
import br.com.robo.adapters.entrypoint.controllers.RoboArtwalkController;
import br.com.robo.domain.usecases.ExecutaRoboArtwalk;
import br.com.robo.domain.ports.ExecutaRoboArtwalkCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CliBeanConfig {

    @Bean("artwalk")
    public ControllerInterface artwalkController() {
        return new RoboArtwalkController();
    }

}
