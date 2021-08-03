package br.com.robo.adapters.entrypoint.controllers;

import br.com.robo.usecases.ports.AbreSiteCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.Properties;

@Controller
public class ArtwalkController implements Controllers {

    private static final Logger logger = LogManager.getLogger(ArtwalkController.class);

    @Autowired
    private AbreSiteCommand abreSiteCommand;

    @Override
    public void execute(Properties properties) {

        logger.info("Abrindo site " + properties.getProperty("url"));

        abreSiteCommand.abreSite(properties);

    }
}
