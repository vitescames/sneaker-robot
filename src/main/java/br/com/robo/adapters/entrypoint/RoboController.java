package br.com.robo.adapters.entrypoint;

import br.com.robo.core.ports.ExecutaRoboCommand;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;

@Named
public class RoboController implements ControllerInterface {

    @Inject
    private ExecutaRoboCommand executaRoboCommand;

    public void execute(HashMap<String, String> params) {

        executaRoboCommand.execute(params);

    }

}
