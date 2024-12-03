package org.rabin.ecommerce.orderLine;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author : rabin
 */
public interface OrderLineRepository  extends JpaRepository<OrderLine, Integer> {
}
