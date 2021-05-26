package pl.matgre.catfacts.service;

import org.springframework.web.bind.annotation.RestController;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.restclient.RestClient;

@RestController
public class Service {

    private final RestClient restClient;

    public Service(RestClient restClient) {
        this.restClient = restClient;
    }

    public CatFact getCatsFact() {
        return restClient.getApiCatsFact();
    }
}
