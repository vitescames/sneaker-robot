package br.com.robo.adapters.entrypoint.cli;

import br.com.robo.adapters.entrypoint.cli.config.ControllerConfig;
import br.com.robo.adapters.entrypoint.cli.config.ParamsConfig;
import br.com.robo.adapters.entrypoint.controllers.ControllerInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@SpringBootApplication
@ComponentScan("br.com.robo")
public class MainStarter implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(MainStarter.class);

    private ControllerInterface controllerInterface;

    @Autowired
    private ControllerConfig controllerConfig;

    @Autowired
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
