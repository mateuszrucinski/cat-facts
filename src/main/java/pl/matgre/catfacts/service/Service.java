package pl.matgre.catfacts.service;

import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.restclient.RestClient;

@org.springframework.stereotype.Service
public class Service {

    private final RestClient restClient;

    public Service(RestClient restClient) {
        this.restClient = restClient;
    }

    public CatFact[] getCatsFact(String amount) {
        return restClient.getApiCatsFact(amount);
    }
}
