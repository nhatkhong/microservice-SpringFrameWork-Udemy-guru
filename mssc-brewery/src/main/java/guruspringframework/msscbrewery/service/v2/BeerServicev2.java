package guruspringframework.msscbrewery.service.v2;

import guruspringframework.msscbrewery.web.model.v2.BeerDTOv2;

import java.util.UUID;

public interface BeerServicev2 {

    BeerDTOv2 getBeer(UUID beerId);

    BeerDTOv2 saveBeer(BeerDTOv2 beerDTOv2);

    void update(UUID beerId, BeerDTOv2 beerDTOv2);

    void deleteById(UUID beerId);
}
