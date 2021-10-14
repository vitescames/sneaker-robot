package br.com.robo.application.rest.controller;

import br.com.robo.adapters.entrypoint.ControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
