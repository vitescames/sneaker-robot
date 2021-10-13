package br.com.robo.adapters.entrypoint.cli.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ParamsConfig {

    @Value("${url}")
    private String url;

    @Value("${email}")
    private String email;

    public HashMap<String, String> execute(){

        HashMap<String, String> retorno = new HashMap<>();

        retorno.put("url", url);
        retorno.put("email", email);

        return retorno;

    }

}
