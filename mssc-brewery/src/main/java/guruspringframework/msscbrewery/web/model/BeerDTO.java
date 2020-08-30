package guruspringframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data //Getters, Setters, Equal and HashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder //Builder pattern?
public class BeerDTO {

    private UUID id;

    private String beerName;

    private String beerStyle;

    private Long upc;
}
