package guruspringframework.msscbrewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data //Getters, Setters, Equal and HashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder //Builder pattern?
public class BeerDTOv2 {

    private UUID id;

    private String beerName;

    private BeerStyleEnum beerStyle;

    private Long upc;
}
