package br.com.robo.core.usecases;

import br.com.robo.core.ports.ArtwalkWebPageGateway;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ProcuraBotaoComprar {

    @Inject
    private ArtwalkWebPageGateway artwalkWebPageGateway;

    public void procurar(String url) {
        artwalkWebPageGateway.procuraBotaoComprar(url);
    }
}
