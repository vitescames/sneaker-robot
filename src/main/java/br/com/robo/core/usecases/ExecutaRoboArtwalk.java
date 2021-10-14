package br.com.robo.core.usecases;

import br.com.robo.core.ports.ArtwalkWebPageGateway;
import br.com.robo.core.ports.ExecutaRoboArtwalkCommand;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;

@Named
public class ExecutaRoboArtwalk implements ExecutaRoboArtwalkCommand {

    @Inject
    private ArtwalkWebPageGateway artwalkWebPageGateway;

    @Override
    public void execute(HashMap<String, String> params) {

        artwalkWebPageGateway.realizaCompra(params);

    }
}
