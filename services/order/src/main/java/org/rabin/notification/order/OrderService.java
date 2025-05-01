package org.rabin.notification.order;


/*
 * @author : rabin
 */

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.rabin.notification.customer.CustomerClient;
import org.rabin.notification.exception.BusinessException;
import org.rabin.notification.kafka.OrderConfirmation;
import org.rabin.notification.kafka.OrderProducer;
import org.rabin.notification.orderLine.OrderLineRequest;
import org.rabin.notification.orderLine.OrderLineService;
import org.rabin.notification.payment.PaymentClient;
import org.rabin.notification.payment.PaymentRequest;
import org.rabin.notification.product.ProductClient;
import org.rabin.notification.product.PurchaseRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Transactional
    public Integer createdOrder(OrderRequest request) {
        // check the customer  --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided Id"));

        // purchase the product --> product - ms using(RestTemplate)
        var purchaseProducts = productClient.purchaseProducts(request.products());

        //persist order
        var order = this.repository.save(mapper.toOrder(request));

        // persist order lines
        for (PurchaseRequest purchaseRequest : request.products()) {
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
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);


        // send the order confirmation --> notification-ms (kafka)
      /*  orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchaseProducts

                )

        );*/
        try {
            orderProducer.sendOrderConfirmation(new OrderConfirmation(
                    request.reference(),
                    request.amount(),
                    request.paymentMethod(),
                    customer,
                    purchaseProducts
            ));
        } catch (Exception e) {
            throw new BusinessException("Failed to send order confirmation message.");
        }


        return order.getId();
    }

    public List<OrderResponse> findAllOrders() {
        return repository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return repository.findById(orderId)
                .map(mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", orderId)));

    }
}
