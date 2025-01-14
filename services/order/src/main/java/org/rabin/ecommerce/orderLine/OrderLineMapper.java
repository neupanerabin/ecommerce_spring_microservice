package org.rabin.ecommerce.orderLine;


/*
 * @author : rabin
 */

import org.springframework.stereotype.Service;
import org.rabin.ecommerce.order.Order;

@Service
public class  OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.orderId())
                .productId(request.productId())
                .order(
                        Order.builder()
                        .id(request.orderId())
                        .build()
                )
                .productId(request.productId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
}
