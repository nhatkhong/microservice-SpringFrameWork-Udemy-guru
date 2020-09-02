package guruspringframework.msscbrewery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data //Getters, Setters, Equal and HashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder //Builder pattern?
public class Beer {

    private UUID id;

    private String beerName;

    private String beerStyle;

    private Long upc;

    private Timestamp createdDate;
    private Timestamp lastUpdatedTDate;
}
