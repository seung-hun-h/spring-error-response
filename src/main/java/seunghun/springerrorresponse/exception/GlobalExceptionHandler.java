package seunghun.springerrorresponse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UnsupportedOperationException.class)
	public ProblemDetail handleUnsupportedOperationException(UnsupportedOperationException exception) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
			HttpStatus.INTERNAL_SERVER_ERROR,
			"Not implemented yet"
		);

		problemDetail.setProperty("errorCode", "FEATURE_NOT_IMPLEMENTED");
		return problemDetail;
	}
}
