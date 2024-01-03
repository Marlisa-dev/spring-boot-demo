package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND) //this allows you to change the status code
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
