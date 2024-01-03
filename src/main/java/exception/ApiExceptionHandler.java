package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

//This class is how we handle more than one exception
@ControllerAdvice //enables this class to work across the entire application
public class ApiExceptionHandler {

    @ExceptionHandler (value = ApiRequestException.class) //This allows spring so its thing by handling this exception. Import above.
    //To handle multiple exceptions, use {} within the value
    public ResponseEntity<Object> handleApiRequestException(
            ApiRequestException e
    ) {

        //client payload
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        //building the response
        return  new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = NotFoundException.class) //This allows spring so its thing by handling this exception. Import above.
    //To handle multiple exceptions, use {} within the value
    public ResponseEntity<Object> handleApiRequestException(
            NotFoundException e
    ) {

        //client payload
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        //building the response
        return  new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND);
    }
}
