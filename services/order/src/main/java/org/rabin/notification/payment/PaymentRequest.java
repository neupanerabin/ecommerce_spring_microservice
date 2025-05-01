package org.rabin.notification.payment;

import org.rabin.notification.customer.CustomerResponse;
import org.rabin.notification.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer

) {
}
