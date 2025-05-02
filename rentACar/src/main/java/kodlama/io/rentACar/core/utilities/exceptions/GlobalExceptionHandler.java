package kodlama.io.rentACar.core.utilities.exceptions;


import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("Validation exception");
        validationProblemDetails.setValidationErrors(new HashMap<>());

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationProblemDetails.getValidationErrors()
                    .put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return validationProblemDetails;
    }
}

