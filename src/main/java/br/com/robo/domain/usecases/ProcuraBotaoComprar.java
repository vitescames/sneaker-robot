package br.com.robo.domain.usecases;

import br.com.robo.domain.ports.ArtwalkWebPageGateway;
import br.com.robo.domain.ports.ProcuraBotaoComprarCommand;
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
