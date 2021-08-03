package br.com.robo.adapters.entrypoint.validators;

import br.com.robo.adapters.entrypoint.controllers.ArtwalkController;

import java.util.Properties;

public class ValidadorDeSite {

    public static String getRoboController(Properties properties){

        if(properties.getProperty("url") != null) {

            if (properties.getProperty("url").contains("artwalk")) {
                return "artwalk";
            }

        }

        return null;

    }

}
