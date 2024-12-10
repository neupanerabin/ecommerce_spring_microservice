package org.rabin.ecommerce.payment;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author : rabin
 */
public interface PaymentRepository  extends JpaRepository<Payment, Integer> {
}
