package br.com.robo.adapters.entrypoint.controllers;

import br.com.robo.domain.ports.ExecutaRoboArtwalkCommand;
import br.com.robo.domain.ports.ProcuraBotaoComprarCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class RoboArtwalkController implements ControllerInterface {

    @Autowired
    private ExecutaRoboArtwalkCommand executaRoboCommand;

    @Autowired
    private ProcuraBotaoComprarCommand procuraBotaoComprarCommand;

    public void execute(HashMap<String, String> params) {

        procuraBotaoComprarCommand.execute(params.get("url"));

        executaRoboCommand.execute(params);

    }

}
