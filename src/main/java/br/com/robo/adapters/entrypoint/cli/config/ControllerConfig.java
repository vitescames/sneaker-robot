package br.com.robo.adapters.entrypoint.cli.config;

import br.com.robo.adapters.entrypoint.controllers.ControllerInterface;
import br.com.robo.adapters.entrypoint.utils.ValidadorDeSite;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ControllerConfig {

    @Autowired
    private BeanFactory beanFactory;

    public ControllerInterface retornaController(String url){
        return beanFactory.getBean(ValidadorDeSite.getRoboController(url), ControllerInterface.class);
    }

}