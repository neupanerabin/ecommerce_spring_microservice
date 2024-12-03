package org.rabin.ecommerce.order;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author : rabin
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
