package seunghun.springerrorresponse.exception;

import org.springframework.validation.FieldError;

public record FieldErrorItem(
	String field,
	Object rejectedValue,
	String message
) {
	public FieldErrorItem(FieldError fieldError) {
		this(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
	}
}
