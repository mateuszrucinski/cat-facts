package pl.matgre.catfacts.mapper;

import org.springframework.stereotype.Component;
import pl.matgre.catfacts.catfactsDto.CatFactsDto;
import pl.matgre.catfacts.model.CatFact;

@Component
public class CatFactDtoToCatFactMapper {

    public CatFact[] mapCatFactDtoToCatFact(CatFactsDto[] catFactsDto) {

        CatFact[] catFacts = new CatFact[catFactsDto.length];

        for(int i = 0; i < catFactsDto.length; i++) {
            CatFactsDto catFactDto = catFactsDto[i];
            CatFact catFact = CatFact.builder()
                    .text(catFactDto.getText())
                    .build();
            catFacts[i] = catFact;
        }

        return catFacts;
    }
}
