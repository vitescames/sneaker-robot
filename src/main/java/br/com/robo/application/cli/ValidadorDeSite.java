package br.com.robo.application.cli;

import javax.inject.Named;

@Named
public class ValidadorDeSite {

    public static String getRoboController(String url){

        if(url != null) {

            if (url.contains("artwalk")) {
                return "artwalk";
            }

        }

        return null;

    }

}
