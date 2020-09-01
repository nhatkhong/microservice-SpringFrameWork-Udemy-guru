package guruspringframework.msscbrewery.web.controller.v2;

import guruspringframework.msscbrewery.service.v2.BeerServicev2;
import guruspringframework.msscbrewery.web.model.v2.BeerDTOv2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerv2 {

    private final BeerServicev2 beerServicev2;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTOv2> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDTOv2 beerDTOv2) {

        log.debug("in handle post...");

        val savedDTO = beerServicev2.saveBeer(beerDTOv2);

        val headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedDTO.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("{/beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDTOv2 beerDTOv2) {

        beerServicev2.update(beerId, beerDTOv2);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{/beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {

        beerServicev2.deleteById(beerId);
    }
}
