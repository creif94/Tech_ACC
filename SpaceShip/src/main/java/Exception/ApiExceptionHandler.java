package Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
@ControllerAdvice // used to hold exception handlers
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class}) // increase values if catch more than one exception
    public ResponseEntity<Object> handleApiException(ApiRequestException e){
        //1. Create a payload containing exception details
        HttpStatus badRequest = BAD_REQUEST;
        ApiException exception = new ApiException(
                e.getMessage(),
                e,
                BAD_REQUEST);
        //2. return response entity
        return new ResponseEntity<>(exception, BAD_REQUEST);
    }
}
