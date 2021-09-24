package br.com.robo.adapters.entrypoint.starters;

import br.com.robo.adapters.entrypoint.config.ControllerConfig;
import br.com.robo.adapters.entrypoint.controllers.ControllerInterface;
import br.com.robo.adapters.entrypoint.utils.MapeadorDeParams;
import br.com.robo.adapters.entrypoint.utils.ValidadorDeSite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.robo.config")
public class MainStarter implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(MainStarter.class);

    @Autowired
    private ControllerInterface controllerInterface;

    @Autowired
    private ControllerConfig config;

    @Value("${url}")
    private String url;

    @Value("${email}")
    private String email;

    public static void main(String[] args) {
        SpringApplication.run(MainStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            controllerInterface = config.retornaController(url);
            controllerInterface.execute(MapeadorDeParams.execute(url, email));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
