package pl.matgre.catfacts.restclient;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.matgre.catfacts.catfactDto.CatFactDto;
import pl.matgre.catfacts.mapper.CatFactDtoToCatFactMapper;
import pl.matgre.catfacts.model.CatFact;

import java.util.List;

@Component
public class RestClient {

    public static final String HTTPS_FACTS_RANDOM = "https://cat-fact.herokuapp.com/facts/random";

    private RestTemplate restTemplate = new RestTemplate();
    private CatFactDtoToCatFactMapper catFactDtoToCatFactMapper = new CatFactDtoToCatFactMapper();

    public CatFact getApiCatsFact() {

        ResponseEntity<CatFactDto> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM,
                HttpMethod.GET,
                null,
                CatFactDto.class
        );

        return catFactDtoToCatFactMapper.mapCatFactDtoToCatFact(exchange.getBody());

    }

    public List<CatFact> getManyApiCatsFacts(String amount) {

        ResponseEntity<CatFactDto[]> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM + "?amount={amount}",
                HttpMethod.GET,
                null,
                CatFactDto[].class,
                amount
        );

        return catFactDtoToCatFactMapper.mapManyCatFactsDtoToCatFacts(exchange.getBody());

    }

}
