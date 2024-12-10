package org.rabin.ecommerce.payment;

import org.rabin.ecommerce.customer.CustomerResponse;
import org.rabin.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer

) {
}
