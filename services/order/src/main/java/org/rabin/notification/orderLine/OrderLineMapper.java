package org.rabin.notification.orderLine;


/*
 * @author : rabin
 */

import org.springframework.stereotype.Service;
import org.rabin.notification.order.Order;

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
