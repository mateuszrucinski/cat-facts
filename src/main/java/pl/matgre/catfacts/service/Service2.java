package pl.matgre.catfacts.service;

import org.springframework.stereotype.Service;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.restclient.RestClient2;

import java.util.List;

@Service
public class Service2 {

    private final RestClient2 restClient;

    public Service2(RestClient2 restClient) {
        this.restClient = restClient;
    }

    public List<CatFact> getManyCatsFacts(String amount) {
        return restClient.getManyApiCatsFacts(amount);
    }

    public CatFact getCatFact() {
        return restClient.getApiCatsFact();
    }
}
