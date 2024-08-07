package com.rabin.config_server.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * @author : rabin
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
