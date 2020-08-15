package es.example.sb.ng.exception;

public class ResourceNotFoundException2 extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    
	public ResourceNotFoundException2(String message) {
		super(message);
	}
	
	public ResourceNotFoundException2(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public ResourceNotFoundException2(Throwable throwable) {
		super(throwable);
	}
	
}