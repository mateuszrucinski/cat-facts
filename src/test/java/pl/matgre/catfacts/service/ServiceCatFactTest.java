package pl.matgre.catfacts.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.restclient.RestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ServiceCatFactTest {

    @InjectMocks
    private ServiceCatFact serviceCatFact;

    @Mock
    private RestClient restClient;

    @Test
    void should_getCatFact() {
        //given
        CatFact expected = restClient.getApiCatsFact();

        //when
        CatFact result = serviceCatFact.getCatFact();

        //then
        assertThat(result).isEqualTo(expected);

    }


    @Test
    void should_getManyCatsFacts() {
        //given
        String amount = "2";
        List<CatFact> expected = restClient.getManyApiCatsFacts("2");

        //when
        List<CatFact> result = serviceCatFact.getManyCatsFacts(amount);

        //then
        assertThat(result).isEqualTo(expected);
    }

}