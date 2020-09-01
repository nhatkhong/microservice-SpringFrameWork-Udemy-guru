package guruspringframework.msscbrewery.web.mapper;

import guruspringframework.msscbrewery.domain.Beer;
import guruspringframework.msscbrewery.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper (uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);

    Beer beerDTOToBeer(BeerDTO beerDTO);

}
