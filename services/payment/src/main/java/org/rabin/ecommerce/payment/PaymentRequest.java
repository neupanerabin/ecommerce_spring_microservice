package org.rabin.ecommerce.payment;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderRefrence,
        Customer customer

        ) {
}