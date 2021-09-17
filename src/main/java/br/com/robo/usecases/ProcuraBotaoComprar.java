package br.com.robo.usecases;

import br.com.robo.usecases.ports.ArtwalkWebPageGateway;
import br.com.robo.usecases.ports.ProcuraBotaoComprarCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcuraBotaoComprar implements ProcuraBotaoComprarCommand {

    @Autowired
    private ArtwalkWebPageGateway artwalkWebPageGateway;

    @Override
    public void execute(String url) {
        artwalkWebPageGateway.procuraBotaoComprar(url);
    }
}
