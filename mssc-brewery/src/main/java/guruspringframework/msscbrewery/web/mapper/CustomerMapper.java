package guruspringframework.msscbrewery.web.mapper;

import guruspringframework.msscbrewery.domain.Customer;
import guruspringframework.msscbrewery.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
