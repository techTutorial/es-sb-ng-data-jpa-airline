package es.example.sb.ng.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long employeeId) {
        super("Employee Id " + employeeId + " not found");
    }
    
	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ResourceNotFoundException(Throwable throwable) {
		super(throwable);
	}

}
