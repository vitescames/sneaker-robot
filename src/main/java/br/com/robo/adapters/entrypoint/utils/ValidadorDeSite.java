package br.com.robo.adapters.entrypoint.utils;

import org.springframework.stereotype.Component;

@Component
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
