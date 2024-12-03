package org.rabin.ecommerce.order;


/*
 * @author : rabin
 */

import lombok.RequiredArgsConstructor;
import org.rabin.ecommerce.customer.CustomerClient;
import org.rabin.ecommerce.exception.BusinessException;
import org.rabin.ecommerce.orderLine.OrderLineRequest;
import org.rabin.ecommerce.orderLine.OrderLineService;
import org.rabin.ecommerce.product.ProductClient;
import org.rabin.ecommerce.product.PurchaseRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private  final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    public Integer createdOrder(OrderRequest request) {
        // check the customer  --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided Id"));

        // purchase the product --> product - ms using(RestTemplate)
        this.productClient.purchaseProducts(request.products());

        //persist order
        var order = this.repository.save(mapper.toOrder(request));

        // persist order lines
        for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                    null,
                    order.getId(),
                    purchaseRequest.productId(),
                    purchaseRequest.quantity()
            )
            );

        }

        // start payment process

        // send the order confirmation --> notification-ms (kafka)
        return null;
    }
}
