package com.mkyong.error;

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