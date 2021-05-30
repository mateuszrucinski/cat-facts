package pl.matgre.catfacts.mapper;

import org.springframework.stereotype.Component;
import pl.matgre.catfacts.model.CatFact;
import pl.matgre.catfacts.catfactsDto.CatFactsDto;

@Component
public class CatFactDtoToCatFactMapper {

    public CatFact mapCatFactDtoToCatFact(CatFactsDto catFactsDto) {

        return CatFact.builder()
                .text(catFactsDto.getText())
                .build();
    }
}
