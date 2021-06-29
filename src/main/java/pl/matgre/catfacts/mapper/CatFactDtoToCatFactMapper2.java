package pl.matgre.catfacts.mapper;

import org.springframework.stereotype.Component;
import pl.matgre.catfacts.catfactsDto.CatFactsDto;
import pl.matgre.catfacts.model.CatFact;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatFactDtoToCatFactMapper2 {

    public List<CatFact> mapManyCatFactsDtoToCatFacts(CatFactsDto[] catFactsDto) {

        List<CatFact> catFacts = new ArrayList<>();

        for(int i = 0; i < catFactsDto.length; i++) {
            CatFactsDto catFactDto = catFactsDto[i];
            CatFact catFact = CatFact.builder()
                    .text(catFactDto.getText())
                    .build();
            catFacts.add(catFact);
        }

        return catFacts;
    }

    public CatFact mapCatFactDtoToCatFact(CatFactsDto catFactsDto) {

        return CatFact.builder()
                .text(catFactsDto.getText())
                .build();

    }
}
