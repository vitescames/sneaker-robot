package br.com.robo.domain.usecases;

import br.com.robo.domain.ports.ArtwalkWebPageGateway;
import br.com.robo.domain.ports.ExecutaRoboArtwalkCommand;
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
