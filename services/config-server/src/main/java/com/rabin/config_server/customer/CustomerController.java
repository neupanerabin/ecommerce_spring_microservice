package com.rabin.config_server.customer;

/*
 * @author : rabin
 */

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor // Generates a constructor for required fields (final fields)
public class CustomerController {

    private final CustomerService service; // Injects the customer service

    // Endpoint to create a new customer
    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return ResponseEntity.ok(service.createCustomer(request)); // Returns the ID of the created customer
    }

    // Endpoint to update an existing customer
    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        service.updateCustomer(request); // Calls the service to update the customer
        return ResponseEntity.accepted().build(); // Returns a 202 Accepted response
    }

    // Endpoint to retrieve all customers
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(service.findAllCustomers()); // Returns the list of all customers
    }

    // Endpoint to check if a customer exists by ID
    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> existsById(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(service.existsById(customerId)); // Returns true if the customer exists, false otherwise
    }

    // Endpoint to retrieve a customer by ID
    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(service.findById(customerId)); // Returns the customer details for the given ID
    }

    // Endpoint to delete a customer by ID
    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> delete(@PathVariable("customer-id") String customerId){
        service.deleteCustomer(customerId); // Calls the service to delete the customer
        return ResponseEntity.accepted().build(); // Returns a 202 Accepted response
    }
}
