package org.rabin.ecommerce.orderLine;


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
