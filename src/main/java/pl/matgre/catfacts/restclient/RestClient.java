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

    public static final String HTTPS_FACTS_RANDOM = "https://cat-fact.herokuapp.com/facts/random?amount=";

    RestTemplate restTemplate = new RestTemplate();
    CatFactDtoToCatFactMapper catFactDtoToCatFactMapper = new CatFactDtoToCatFactMapper();

    public CatFact getApiCatsFact(String amount) {

        ResponseEntity<CatFactsDto> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM + "{amount}",
                HttpMethod.GET,
                null,
                CatFactsDto.class,
                amount
        );

        CatFact catFact = catFactDtoToCatFactMapper.mapCatFactDtoToCatFact(exchange.getBody());

        return catFact;

    }

}
