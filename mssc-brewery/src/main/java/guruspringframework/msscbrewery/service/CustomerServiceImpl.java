package guruspringframework.msscbrewery.service;

import guruspringframework.msscbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomer(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .customerName("Gemi")
                .build();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void update(UUID customerId, CustomerDTO customerDTO) {

        //todo impl - would add a real impl to update beer
    }

    @Override
    public void deleteById(UUID customerId) {

        //todo impl - would delete a real impl
        log.debug("Deleting a customer...");
    }
}
