package br.com.robo.core.usecases;

import br.com.robo.core.ports.ArtwalkWebPageGateway;
import br.com.robo.core.ports.ProcuraBotaoComprarCommand;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ProcuraBotaoComprar implements ProcuraBotaoComprarCommand {

    @Inject
    private ArtwalkWebPageGateway artwalkWebPageGateway;

    @Override
    public void execute(String url) {
        artwalkWebPageGateway.procuraBotaoComprar(url);
    }
}
