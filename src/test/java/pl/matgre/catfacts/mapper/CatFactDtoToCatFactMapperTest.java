package pl.matgre.catfacts.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.matgre.catfacts.catfactDto.CatFactDto;
import pl.matgre.catfacts.model.CatFact;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CatFactDtoToCatFactMapperTest {

    @InjectMocks
    CatFactDtoToCatFactMapper mapper;

    @Test
    void should_map_CatFactDto_To_CatFact() {
        //given
        CatFact expected = catFact();

        //when
        CatFact result = mapper.mapCatFactDtoToCatFact(catFactDto());

        //then
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);

    }

    private CatFact catFact() {
        return CatFact.builder()
                .text("any")
                .build();
    }

    private CatFactDto catFactDto() {
        return CatFactDto.builder()
                .text("any")
                .build();
    }

}