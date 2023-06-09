package chaw.personalproject.pms.projectmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName,
                                     String fieldName,
                                     Long fieldValue) {
        // Custom exception message
        super(String.format("%s is not found with %s: '%s'",
                resourceName,
                fieldName,
                fieldValue));
    }
}
