package guruspringframework.msscbrewery.service;

import guruspringframework.msscbrewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDTO getBeer(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Saigon")
                .beerStyle("Sweet")
                .build();
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void update(UUID beerId, BeerDTO beerDTO) {

        //todo impl - would add a real impl to update beer
    }

    @Override
    public void deleteById(UUID beerId) {

        //todo impl - would delete a real impl
        log.debug("Deleting a beer...");
    }
}
