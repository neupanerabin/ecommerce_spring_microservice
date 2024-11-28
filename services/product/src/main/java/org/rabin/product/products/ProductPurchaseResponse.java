package org.rabin.product.products;


/*
 * @author : rabin
 */

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity


) {
}
