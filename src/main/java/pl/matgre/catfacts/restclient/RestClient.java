package pl.matgre.catfacts.restclient;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.catfactsDto.CatFactsDto;
import pl.matgre.catfacts.mapper.CatFactDtoToCatFactMapper;

@Component
public class RestClient {

    public static final String HTTPS_FACTS_RANDOM = "https://cat-fact.herokuapp.com/facts/random";

    RestTemplate restTemplate = new RestTemplate();
    CatFactDtoToCatFactMapper catFactDtoToCatFactMapper = new CatFactDtoToCatFactMapper();

    public CatFact getApiCatsFact() {

        ResponseEntity<CatFactsDto> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM,
                HttpMethod.GET,
                null,
                CatFactsDto.class
        );

        CatFact catFact = catFactDtoToCatFactMapper.catFactDtoToCatFactMapper(exchange.getBody());

        return catFact;

    }

}
