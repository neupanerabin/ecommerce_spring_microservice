package org.rabin.ecommerce.order;


/*
 * @author : rabin
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.rabin.ecommerce.product.PurchaseRequest;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(Include.NON_EMPTY)
public record OrderRequest (
        Integer id,
        String reference,
        @Positive(message="Order amount should be positive")
        BigDecimal amount,
        @NotNull(message="Payment amount should be positive")
        PaymentMethod paymentMethod,
        @NotNull(message="Customer should be present")
        @NotEmpty(message="Customer should be present")
        @NotBlank(message="Customer should be present")
        String customerId,
        @NotEmpty(message = "You should at least one purchase one product")
        List<PurchaseRequest> products
){

}
