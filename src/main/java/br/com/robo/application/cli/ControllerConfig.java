package br.com.robo.application.cli;

import br.com.robo.adapters.entrypoint.ControllerInterface;
import org.springframework.beans.factory.BeanFactory;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ControllerConfig {

    @Inject
    private BeanFactory beanFactory;

    public ControllerInterface retornaController(String url){
        return beanFactory.getBean(ValidadorDeSite.getRoboController(url), ControllerInterface.class);
    }

}
