package br.com.robo.external.entrypoint.cli;

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
