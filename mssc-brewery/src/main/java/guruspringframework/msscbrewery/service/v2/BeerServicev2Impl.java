package guruspringframework.msscbrewery.service.v2;

import guruspringframework.msscbrewery.web.model.v2.BeerDTOv2;
import guruspringframework.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServicev2Impl implements BeerServicev2 {

    @Override
    public BeerDTOv2 getBeer(UUID beerId) {
        return BeerDTOv2.builder().id(UUID.randomUUID())
                .beerName("Saigon")
                .beerStyle(BeerStyleEnum.GOSE)
                .build();
    }

    @Override
    public BeerDTOv2 saveBeer(BeerDTOv2 beerDTOv2) {
        return BeerDTOv2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void update(UUID beerId, BeerDTOv2 beerDTOv2) {

        //todo impl - would add a real impl to update beer
    }

    @Override
    public void deleteById(UUID beerId) {

        //todo impl - would delete a real impl
        log.debug("Deleting a beer...");
    }
}
