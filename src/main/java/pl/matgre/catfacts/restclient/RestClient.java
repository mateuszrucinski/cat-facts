package pl.matgre.catfacts.restclient;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.catfactsDto.CatFactsDto;
import pl.matgre.catfacts.mapper.CatFactDtoToCatFactMapper;

import java.util.Arrays;

@Component
public class RestClient {

    public static final String HTTPS_FACTS_RANDOM = "https://cat-fact.herokuapp.com/facts/random?amount={amount}";

    RestTemplate restTemplate = new RestTemplate();
    CatFactDtoToCatFactMapper catFactDtoToCatFactMapper = new CatFactDtoToCatFactMapper();

    public CatFact[] getApiCatsFact(String amount) {

//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity <String> entity = new HttpEntity<String>(headers);

        ResponseEntity<CatFactsDto[]> exchange = restTemplate.exchange(
                HTTPS_FACTS_RANDOM,
                HttpMethod.GET,
                null,
                CatFactsDto[].class,
                amount
        );

        CatFact[] catFact = catFactDtoToCatFactMapper.mapCatFactDtoToCatFact(exchange.getBody());

        return catFact;

    }

}
