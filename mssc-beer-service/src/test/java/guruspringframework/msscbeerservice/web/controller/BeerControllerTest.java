package guruspringframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guruspringframework.msscbeerservice.web.model.BeerDTO;
import guruspringframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "guruspringframework.msscbeerservice.web.mapper")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDTO beerDTO = getValidBeerDTO();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {

        BeerDTO beerDTO = getValidBeerDTO();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isNoContent());
    }

    BeerDTO getValidBeerDTO() {
        return BeerDTO.builder()
                .beerName("Valid Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("9.98"))
                .upc(123455980584L)
                .build();
    }
}