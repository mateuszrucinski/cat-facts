package pl.matgre.catfacts.mapper;

import org.springframework.stereotype.Component;
import pl.matgre.catfacts.catfactsDto.CatFactDto;
import pl.matgre.catfacts.model.CatFact;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatFactDtoToCatFactMapper {

    public CatFact mapCatFactDtoToCatFact(CatFactDto catFactDto) {

        return CatFact.builder()
                .text(catFactDto.getText())
                .build();

    }

    public List<CatFact> mapManyCatFactsDtoToCatFacts(CatFactDto[] catFactsDto) {

        List<CatFact> catFacts = new ArrayList<>();

        for (CatFactDto catFactDto : catFactsDto) {
            CatFact catFact = CatFact.builder()
                    .text(catFactDto.getText())
                    .build();
            catFacts.add(catFact);
        }

        return catFacts;
    }
}
