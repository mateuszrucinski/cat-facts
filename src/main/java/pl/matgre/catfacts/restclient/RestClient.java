package pl.matgre.catfacts.restclient;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.matgre.catfacts.catfactsDto.CatFactsDto;
import pl.matgre.catfacts.mapper.CatFactDtoToCatFactMapper;
import pl.matgre.catfacts.model.CatFact;

import java.util.List;

@Component
public class RestClient {

    public static final String HTTPS_FACTS_RANDOM = "https://cat-fact.herokuapp.com/facts/random";

    private RestTemplate restTemplate = new RestTemplate();
    private CatFactDtoToCatFactMapper catFactDtoToCatFactMapper = new CatFactDtoToCatFactMapper();

    public List<CatFact> getManyApiCatsFacts(String amount) {

        ResponseEntity<CatFactsDto[]> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM + "?amount={amount}",
                HttpMethod.GET,
                null,
                CatFactsDto[].class,
                amount
        );

        return catFactDtoToCatFactMapper.mapManyCatFactsDtoToCatFacts(exchange.getBody());

    }


    public CatFact getApiCatsFact() {

        ResponseEntity<CatFactsDto> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM,
                HttpMethod.GET,
                null,
                CatFactsDto.class
        );

        return catFactDtoToCatFactMapper.mapCatFactDtoToCatFact(exchange.getBody());

    }

}
