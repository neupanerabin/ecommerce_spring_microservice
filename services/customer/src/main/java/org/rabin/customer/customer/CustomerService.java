package org.rabin.customer.customer;

/*
 * @author : rabin
 */

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.rabin.customer.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor // Generates a constructor for required fields (final fields)
public class CustomerService {

    private final CustomerRepository repository; // Injects the customer repository
    private final CustomerMapper mapper; // Injects the customer mapper for DTO conversions

    // Method to create a new customer
    public String createCustomer(CustomerRequest request) {
        var customer = this.repository.save(mapper.toCustomer(request)); // Maps request to Customer and saves it
        return customer.getId(); // Returns the ID of the newly created customer
    }

    // Method to update an existing customer
    public void updateCustomer(CustomerRequest request) {
        var customer = this.repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())
                ));
        mergeCustomer(customer, request); // Merges the updated fields into the existing customer
        repository.save(customer); // Saves the updated customer
    }

    // Helper method to merge updated fields into the existing customer object
    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname()); // Updates the first name if provided
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname()); // Updates the last name if provided
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email()); // Updates the email if provided
        }
        if (request.address() != null) {
            customer.setAddress(request.address()); // Updates the address if provided
        }
    }

    // Method to find all customers
    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(this.mapper::fromCustomer) // Converts each Customer to CustomerResponse
                .collect(Collectors.toList());
    }


/////
    // Method to check if a customer exists by ID
    public Boolean existsById(String customerId) {
        return this.repository.findById(customerId).isPresent();
    }

    // Method to find a customer by ID
    public CustomerResponse findById(String customerId) {
        return this.repository.findById(customerId)
                .map(mapper::fromCustomer) // Converts Customer to CustomerResponse if found
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("No customer found with the provided ID: %s", customerId)
                ));
    }

    // Method to delete a customer by ID
    public void deleteCustomer(String customerId) {
        this.repository.deleteById(customerId); // Deletes the customer by ID
    }
}
