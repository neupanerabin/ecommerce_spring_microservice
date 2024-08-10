package org.rabin.customer.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * @author : rabin
 */

// Repository interface for Customer entities, extending MongoRepository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
