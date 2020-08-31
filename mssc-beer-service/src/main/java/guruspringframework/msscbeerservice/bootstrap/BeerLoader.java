package guruspringframework.msscbeerservice.bootstrap;

import guruspringframework.msscbeerservice.domain.Beer;
import guruspringframework.msscbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {

        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if(beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Saigon")
                    .beerStyle("GOSE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(33701000002L)
                    .price(new BigDecimal("11.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("333")
                    .beerStyle("ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(33701000001L)
                    .price(new BigDecimal("12.95"))
                    .build());
        }
    }
}
