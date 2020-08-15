package es.example.sb.ng.exception;

import java.util.Set;

public class ResourceUnSupportedFieldPatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allowed.");
    }

}
