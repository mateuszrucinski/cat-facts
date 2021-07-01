package pl.matgre.catfacts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.service.ServiceCatFact;

import java.util.List;

@RestController
public class Controller {

    private final ServiceCatFact serviceCatFact;

    public Controller(ServiceCatFact serviceCatFact) {
        this.serviceCatFact = serviceCatFact;
    }

    @GetMapping("/catfact")
    public CatFact getCatsFact() {
        return serviceCatFact.getCatFact();
    }

    @GetMapping("/catfacts")
    public List<CatFact> getManyCatsFacts(@RequestParam String amount) {
        return serviceCatFact.getManyCatsFacts(amount);
    }
}
