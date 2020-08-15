package es.example.sb.ng.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class EsGlobalExceptionHandler2 extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException2.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
    	// override only status code
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(ResourceUnSupportedFieldPatchException.class)
    public void springUnSupportedFieldPatch(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value());
    }

    // @Validated: Validate Path Variables and Request Parameters > verification > Pending
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    /*@ExceptionHandler(ResourceNotFoundException2.class)
    public ResponseEntity<EsError2> customHandleNotFound(Exception ex, WebRequest request) {
        EsError2 errors = new EsError2();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }*/

    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    		MethodArgumentNotValidException ex, HttpHeaders headers,
    		HttpStatus status, WebRequest request) {
    	
        Map<String, Object> errorMap = new LinkedHashMap<>();
        errorMap.put("timestamp", new Date());
        errorMap.put("status", status.value());
        List<String> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        errorMap.put("errors", fieldErrors); // add all errors

        // skip
		Map<String, String> fieldErrors2 = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        
        return new ResponseEntity<>(errorMap, headers, status);
    }

}
