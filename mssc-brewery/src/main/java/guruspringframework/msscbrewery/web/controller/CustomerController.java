package guruspringframework.msscbrewery.web.controller;

import guruspringframework.msscbrewery.service.CustomerService;
import guruspringframework.msscbrewery.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId")
                                                           UUID customerId) {

        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity handlePost(CustomerDTO customerDTO) {

        CustomerDTO savedDTO = customerService.saveCustomer(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedDTO.getId().toString());

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO) {

        customerService.update(customerId, customerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {

        customerService.deleteById(customerId);
    }
}
