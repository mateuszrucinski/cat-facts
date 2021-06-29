package pl.matgre.catfacts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.service.Service2;

import java.util.List;

@RestController
public class Controller2 {

    private final Service2 service;

    public Controller2(Service2 service) {
        this.service = service;
    }

    @GetMapping("/catfacts/list")
    public List<CatFact> getManyCatsFacts(@RequestParam String amount) {
        return service.getManyCatsFacts(amount);
    }

    @GetMapping("/catfact")
    public CatFact getCatsFact() {
        return service.getCatFact();
    }
}
