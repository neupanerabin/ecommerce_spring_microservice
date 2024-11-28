package org.rabin.product.products;


/*
 * @author : rabin
 */

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductResponse (
         Integer id,
         String name,
         String description,
         double availableQuantity,
         BigDecimal price,
         Integer categoryId,
         String categoryName,
         String categoryDescription

        ){
}

