package br.com.robo.usecases;

import br.com.robo.usecases.ports.ExecutaRoboArtwalkCommand;
import br.com.robo.usecases.ports.ArtwalkWebPageGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ExecutaRoboArtwalk implements ExecutaRoboArtwalkCommand {

    @Autowired
    private ArtwalkWebPageGateway artwalkWebPageGateway;

    @Override
    public void execute(HashMap<String, String> params) {

        artwalkWebPageGateway.realizaCompra(params);

    }
}
