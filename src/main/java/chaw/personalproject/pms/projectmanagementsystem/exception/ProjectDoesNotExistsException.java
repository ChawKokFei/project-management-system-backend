package chaw.personalproject.pms.projectmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProjectDoesNotExistsException extends RuntimeException {
    public ProjectDoesNotExistsException(String message) {
        super(message);
    }
}
