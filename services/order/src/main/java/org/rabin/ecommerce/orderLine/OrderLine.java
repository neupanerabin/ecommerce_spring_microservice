package org.rabin.ecommerce.orderLine;


/*
 * @author : rabin
 */

import jakarta.persistence.*;
import lombok.*;
import org.rabin.ecommerce.order.Order;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;
}
