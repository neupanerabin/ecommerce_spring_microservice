package org.rabin.ecommerce.payment;


/*
 * @author : rabin
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "product-service",
        url = "${spring.application.config.payment-url}"
//        url= "http://localhost:8060/api/v1/payments"


)
public interface PaymentClient {

    @PostMapping
    Integer requestOrderPayment(@RequestBody PaymentRequest request);
}
