package org.rabin.notification.orderLine;


/*
 * @author : rabin
 */


public record OrderLineRequest (
        Integer id,
        Integer orderId,
        Integer productId,
        double quantity
) {

}
