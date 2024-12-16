package org.rabin.ecommerce.payment;


/*
 * @author : rabin
 */

import lombok.RequiredArgsConstructor;
import org.rabin.ecommerce.notification.NotificationProducer;
import org.rabin.ecommerce.notification.PaymentNotificationRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private  final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = this.repository.save(this.mapper.toPayment(request));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()

                )
        );
        return payment.getId();
    }
}
