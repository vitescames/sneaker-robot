package br.com.robo.core.usecases;

import br.com.robo.core.ports.ArtwalkWebPageGateway;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;

@Named
public class RealizaCompra {

    @Inject
    private ArtwalkWebPageGateway artwalkWebPageGateway;

    public void realiza(HashMap<String, String> params) {

        artwalkWebPageGateway.realizaCompra(params);

    }

}
