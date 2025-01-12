package org.rabin.ecommerce.kafka;


/*
 * @author : rabin
 */



import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rabin.ecommerce.email.EmailService;
import org.rabin.ecommerce.kafka.order.OrderConfirmation;
import org.rabin.ecommerce.kafka.payment.PaymentConfirmation;
import org.rabin.ecommerce.notification.Notification;
import org.rabin.ecommerce.notification.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.rabin.ecommerce.notification.NotificationType.ORDER_CONFIRMATION;
import static org.rabin.ecommerce.notification.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
//    @KafkaListener(topics = "payment-topic", groupId = "payment-group,orderGroup")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );

        // to do send email
        var customerName = paymentConfirmation.customerFirstname() + " " + paymentConfirmation.customerLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()

        );

    }

//    @KafkaListener(topics = "order-topic")
    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consumeConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(String.format("Consuming the message from payment-topic Topic:: %s", orderConfirmation));
        repository.save(
                Notification.builder().type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        // to do send email
        var customerName = orderConfirmation.customer().firstname() + " " + orderConfirmation.customer().lastname();
        try {
            emailService.sendOrderConfirmationEmail(
                    orderConfirmation.customer().email(),
                    customerName,
                    orderConfirmation.totalAmount(),
                    orderConfirmation.orderReference(),
                    orderConfirmation.products()
            );
        } catch (MessagingException e) {
            log.error("Failed to send order confirmation email to {}", orderConfirmation.customer().email(), e);
        }
       /* emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()

        );*/
    }
}
