package org.rabin.ecommerce.kafka;


/*
 * @author : rabin
 */

import org.rabin.ecommerce.customer.CustomerResponse;
import org.rabin.ecommerce.order.PaymentMethod;
import org.rabin.ecommerce.product.PurchaseResponse;

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
