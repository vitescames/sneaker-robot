package br.com.robo.application.cli;

import br.com.robo.adapters.entrypoint.ControllerInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import javax.inject.Inject;
import java.util.HashMap;

@SpringBootApplication
@ComponentScan("br.com.robo")
public class MainStarter implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(MainStarter.class);

    @Inject
    private ControllerInterface controllerInterface;

    @Inject
    private ParamsConfig paramsConfig;

    public static void main(String[] args) {
        new SpringApplicationBuilder(MainStarter.class)
        .web(WebApplicationType.NONE)
        .run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        HashMap<String, String> params = paramsConfig.execute();

        try{
            controllerInterface.execute(params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
