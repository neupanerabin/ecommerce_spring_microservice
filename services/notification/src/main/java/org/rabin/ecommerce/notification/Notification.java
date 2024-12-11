package org.rabin.ecommerce.notification;


/*
 * @author : rabin
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.rabin.ecommerce.kafka.order.OrderConfirmation;
import org.rabin.ecommerce.kafka.payment.PaymentConfirmation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;

    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;




}
