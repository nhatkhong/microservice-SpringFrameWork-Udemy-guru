package guruspringframework.msscbrewery.service;

import guruspringframework.msscbrewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {

    BeerDTO getBeer(UUID beerId);

    BeerDTO saveBeer(BeerDTO beerDTO);

    void update(UUID beerId, BeerDTO beerDTO);

    void deleteById(UUID beerId);
}
