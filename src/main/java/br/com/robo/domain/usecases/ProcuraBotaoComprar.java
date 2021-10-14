package br.com.robo.domain.usecases;

import br.com.robo.domain.ports.ArtwalkWebPageGateway;
import br.com.robo.domain.ports.ProcuraBotaoComprarCommand;

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
