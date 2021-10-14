package br.com.robo.config.entrypoint.cli;

import br.com.robo.adapters.entrypoint.ControllerInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.inject.Inject;
import java.util.HashMap;

@SpringBootApplication
@ComponentScan("br.com.robo")
public class MainStarter implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(MainStarter.class);

    private ControllerInterface controllerInterface;

    @Inject
    private ControllerConfig controllerConfig;

    @Inject
    private ParamsConfig paramsConfig;

    public static void main(String[] args) {
        SpringApplication.run(MainStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        HashMap<String, String> params = paramsConfig.execute();

        try{
            controllerInterface = controllerConfig.retornaController(params.get("url"));
            controllerInterface.execute(params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
