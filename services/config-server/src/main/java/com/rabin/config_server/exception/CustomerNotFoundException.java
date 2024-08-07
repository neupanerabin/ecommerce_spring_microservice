package com.rabin.config_server.exception;


/*
 * @author : rabin
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends  RuntimeException {
    private final String msg;
}
