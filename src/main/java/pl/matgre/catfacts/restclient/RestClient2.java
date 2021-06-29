package pl.matgre.catfacts.restclient;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.matgre.catfacts.catfactsDto.CatFactsDto;
import pl.matgre.catfacts.mapper.CatFactDtoToCatFactMapper2;
import pl.matgre.catfacts.model.CatFact;

import java.util.List;

@Component
public class RestClient2 {

    public static final String HTTPS_FACTS_RANDOM = "https://cat-fact.herokuapp.com/facts/random";

    private RestTemplate restTemplate = new RestTemplate();
    private CatFactDtoToCatFactMapper2 catFactDtoToCatFactMapper2 = new CatFactDtoToCatFactMapper2();

    public List<CatFact> getManyApiCatsFacts(String amount) {

        ResponseEntity<CatFactsDto[]> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM + "?amount={amount}",
                HttpMethod.GET,
                null,
                CatFactsDto[].class,
                amount
        );

        return catFactDtoToCatFactMapper2.mapManyCatFactsDtoToCatFacts(exchange.getBody());

    }


    public CatFact getApiCatsFact() {

        ResponseEntity<CatFactsDto> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM,
                HttpMethod.GET,
                null,
                CatFactsDto.class
        );

        return catFactDtoToCatFactMapper2.mapCatFactDtoToCatFact(exchange.getBody());

    }

}
