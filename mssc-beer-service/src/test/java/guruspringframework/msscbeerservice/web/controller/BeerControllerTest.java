package guruspringframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guruspringframework.msscbeerservice.bootstrap.BeerLoader;
import guruspringframework.msscbeerservice.service.BeerService;
import guruspringframework.msscbeerservice.web.model.BeerDTO;
import guruspringframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "dev.springframework.guru", uriPort = 80)
@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "guruspringframework.msscbeerservice.web.mapper")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getBeerById(any())).willReturn(getValidBeerDTO());

        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/beer/{beerId}", UUID.randomUUID().toString())
                .param("isCold", "yes")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/beer-get", pathParameters(
                        parameterWithName("beerId").description("UUID of desired beer to get.")),
                        requestParameters(parameterWithName("isCold").description("Is beer cold query")),
                        responseFields(
                                fieldWithPath("id").description("Beer Id"),
                                fieldWithPath("version").description("Version number"),
                                fieldWithPath("createdDate").description("Date Created"),
                                fieldWithPath("lastModifiedDate").description("Date Updated"),
                                fieldWithPath("beerName").description("Beer Name"),
                                fieldWithPath("beerStyle").description("Beer Style"),
                                fieldWithPath("upc").description("UPC of Beer"),
                                fieldWithPath("price").description("Price"),
                                fieldWithPath("quantityOnHand").description("Quantity On hand"),
                                fieldWithPath("myLocalDate").description("Local Date"))
                ));
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDTO beerDTO = getValidBeerDTO();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDTO());

        ConstrainedFields fields = new ConstrainedFields(BeerDTO.class);

        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/beer-new", requestFields(
                        fields.withPath("id").ignored(),
                        fields.withPath("version").ignored(),
                        fields.withPath("createdDate").ignored(),
                        fields.withPath("lastModifiedDate").ignored(),
                        fields.withPath("beerName").description("Beer Name"),
                        fields.withPath("beerStyle").description("Beer Style"),
                        fields.withPath("upc").description("UPC of Beer"),
                        fields.withPath("price").description("Price"),
                        fields.withPath("quantityOnHand").ignored(),
                        fields.withPath("myLocalDate").description("Local Date"))
                ));
    }

    @Test
    void updateBeerById() throws Exception {

        given(beerService.update(any(), any())).willReturn(getValidBeerDTO());

        BeerDTO beerDTO = getValidBeerDTO();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isNoContent());
    }

    BeerDTO getValidBeerDTO() {
        return BeerDTO.builder()
                .beerName("Valid Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("9.98"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }

    private static class ConstrainedFields {

        private final ConstraintDescriptions constraintDescriptions;

        ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path) {
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". ")));
        }
    }
}