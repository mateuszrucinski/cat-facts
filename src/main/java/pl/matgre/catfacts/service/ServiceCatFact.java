package pl.matgre.catfacts.service;

import org.springframework.stereotype.Service;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.restclient.RestClient;

import java.util.List;

@Service
public class ServiceCatFact {

    private final RestClient restClient;

    public ServiceCatFact(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<CatFact> getManyCatsFacts(String amount) {
        return restClient.getManyApiCatsFacts(amount);
    }

    public CatFact getCatFact() {
        return restClient.getApiCatsFact();
    }
}
