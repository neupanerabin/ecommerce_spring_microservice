package org.rabin.notification.kafka;


/*
 * @author : rabin
 */

import org.rabin.notification.customer.CustomerResponse;
import org.rabin.notification.order.PaymentMethod;
import org.rabin.notification.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
