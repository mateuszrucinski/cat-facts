package pl.matgre.catfacts.restclient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.matgre.catfacts.catfactDto.CatFactDto;
import pl.matgre.catfacts.mapper.CatFactDtoToCatFactMapper;
import pl.matgre.catfacts.model.CatFact;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestClientTest {

    @InjectMocks
    private RestClient restClient;

    @Mock
    private CatFactDtoToCatFactMapper catFactDtoToCatFactMapper;

    @Test
    void should_getApiCatsFact() {
        //given
        CatFact expected = catFact();
        when(catFactDtoToCatFactMapper.mapCatFactDtoToCatFact(any(CatFactDto.class))).thenReturn(expected);

        //when
        CatFact result = restClient.getApiCatsFact();

        //then
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void should_getManyApiCatsFacts() {
        //given
        String amount = "3";
        CatFactDto[] catFactDto = new CatFactDto[3];

        List<CatFact> expected = manyCatFacts(catFactDto);
        when(catFactDtoToCatFactMapper.mapManyCatFactsDtoToCatFacts(any(CatFactDto[].class))).thenReturn(expected);

        //when
        List<CatFact> result = restClient.getManyApiCatsFacts(amount);

        //then
        assertThat(result).isEqualTo(expected);

    }

    private CatFact catFact() {
        return CatFact.builder()
                .text("any")
                .build();
    }

    private List<CatFact> manyCatFacts(CatFactDto[] catFactsDto) {

        List<CatFact> catFacts = new ArrayList<>();

        for (CatFactDto catFactDto : catFactsDto) {

            CatFact catFact = CatFact.builder()
                    .text("any")
                    .build();

            catFacts.add(catFact);
        }

        return catFacts;
    }

}