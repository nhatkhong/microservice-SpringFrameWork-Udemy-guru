package guruspringframework.msscbrewery.service;

import guruspringframework.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomer(UUID customerId);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    void update(UUID customerId, CustomerDTO customerDTO);

    void deleteById(UUID customerId);
}
