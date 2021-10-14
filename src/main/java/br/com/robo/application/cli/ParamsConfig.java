package br.com.robo.application.cli;

import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;
import java.util.HashMap;

@Named
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
