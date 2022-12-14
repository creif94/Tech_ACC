package Exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;



    public ApiException(String message,
                        Throwable cause,
                        HttpStatus httpStatus
                        ) {
        this.message = message;
        this.cause = cause;
        this.httpStatus = httpStatus;

    }

    //Getters
    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}

