package org.rabin.ecommerce.exception;


/*
 * @author : rabin
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private final String msg;

}
