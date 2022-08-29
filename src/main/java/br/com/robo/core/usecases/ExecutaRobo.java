package br.com.robo.core.usecases;

import br.com.robo.core.ports.ArtwalkWebPageGateway;
import br.com.robo.core.ports.ExecutaRoboCommand;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;

@Named
public class ExecutaRobo implements ExecutaRoboCommand {

    @Inject
    private RealizaCompra realizaCompra;

    @Inject
    private ProcuraBotaoComprar procuraBotaoComprar;

    @Override
    public void execute(HashMap<String, String> params) {

        procuraBotaoComprar.procurar(params.get("url"));

        realizaCompra.realiza(params);

    }
}
