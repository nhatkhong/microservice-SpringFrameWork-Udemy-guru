package guruspringframework.msscbeerservice.web.mapper;

import guruspringframework.msscbeerservice.domain.Beer;
import guruspringframework.msscbeerservice.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper (uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);

    Beer beerDTOToBeer(BeerDTO beer);
}
