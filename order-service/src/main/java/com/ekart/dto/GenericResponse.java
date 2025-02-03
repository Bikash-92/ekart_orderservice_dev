/**
 * Author: BIKASH
 */

package com.ekart.dto;


import lombok.Data;

import java.util.Set;

@Data
public class GenericResponse {

    private String message;
    private Set<Object> errors;
    private Object successResponseObject;
    private String statusCode;


}
