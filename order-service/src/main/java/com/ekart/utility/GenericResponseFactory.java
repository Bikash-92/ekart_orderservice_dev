/**
 * Author: BIKASH
 */
package com.ekart.utility;

import com.ekart.dto.GenericResponse;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GenericResponseFactory {

    public GenericResponse constructGenericResponse(String message,
                                                    String statusCode,Object object,
                                                    Set<Object> errors){
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setMessage(message);
        genericResponse.setStatusCode(statusCode);
        genericResponse.setSuccessResponseObject(object);
        genericResponse.setErrors(errors);

        return genericResponse;
    }

}
