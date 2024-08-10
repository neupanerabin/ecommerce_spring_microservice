package org.rabin.customer.handler;

/*
 * @author : rabin
 */

import java.util.Map;

// Record class representing an error response structure
public record ErrorResponse (
        Map<String, String> errors // A map containing field names as keys and corresponding error messages as values
){
}
