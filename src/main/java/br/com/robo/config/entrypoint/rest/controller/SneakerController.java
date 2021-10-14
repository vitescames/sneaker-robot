package br.com.robo.config.entrypoint.rest.controller;

import br.com.robo.adapters.entrypoint.ControllerInterface;
import br.com.robo.adapters.entrypoint.RoboArtwalkController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("artwalk")
public class SneakerController {

    @Autowired
    @Qualifier("artwalk")
    private ControllerInterface controller;

    @PostMapping
    public ResponseEntity<Object> buySneaker(){
        System.out.println("Rest controller");
        //roboArtwalkController.execute(new HashMap<>());
        return null;
    }

}
