package br.com.robo.config.starters;

import br.com.robo.adapters.entrypoint.controllers.Controllers;
import br.com.robo.adapters.entrypoint.validators.ValidadorDeSite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileInputStream;
import java.util.Properties;

@SpringBootApplication
@ComponentScan("br.com.robo.config")
public class MainStarter implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(MainStarter.class);

    private Controllers controller;

    @Autowired
    private BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(MainStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String path = args[0];

        Properties properties = new Properties();

        try{
            logger.info("Lendo arquivo .properties");
            properties.load(new FileInputStream(path));
            controller = beanFactory.getBean(ValidadorDeSite.getRoboController(properties), Controllers.class);
            controller.execute(properties);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
