package Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(value = APIRequestException.class)
    public ResponseEntity<Object> handleExceptions(APIRequestException e) {
        HttpStatus badRequest = BAD_REQUEST;
        APIJsonReturn exception = new APIJsonReturn(e.getMessage(),e, BAD_REQUEST);
        return new ResponseEntity<>(exception,BAD_REQUEST);


    }
}
