package br.com.robo.adapters.entrypoint;

import br.com.robo.core.ports.ExecutaRoboArtwalkCommand;
import br.com.robo.core.ports.ProcuraBotaoComprarCommand;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;

@Named("artwalk")
public class RoboArtwalkController implements ControllerInterface {

    @Inject
    private ExecutaRoboArtwalkCommand executaRoboCommand;

    @Inject
    private ProcuraBotaoComprarCommand procuraBotaoComprarCommand;

    public void execute(HashMap<String, String> params) {

        procuraBotaoComprarCommand.execute(params.get("url"));

        executaRoboCommand.execute(params);

    }

}
