package br.com.robo.adapters.entrypoint.utils;

import java.util.HashMap;

public class MapeadorDeParams {

    public static HashMap<String, String> execute(String url, String email){

        HashMap<String, String> retorno = new HashMap<>();

        retorno.put("url", url);
        retorno.put("email", email);

        return retorno;

    }

}
