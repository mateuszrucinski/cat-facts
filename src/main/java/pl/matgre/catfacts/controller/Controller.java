package pl.matgre.catfacts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.service.Service;

@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/catfacts")
    public CatFact[] getCatsFact(@RequestParam String amount) {
        return service.getCatsFact(amount);
    }
}
