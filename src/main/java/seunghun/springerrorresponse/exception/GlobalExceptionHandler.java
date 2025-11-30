package seunghun.springerrorresponse.exception;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Invalid request parameter");

		List<FieldErrorItem> fieldErrors = exception.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(FieldErrorItem::new)
			.toList();

		problemDetail.setProperty("errors", fieldErrors);

		return problemDetail;
	}
	//
	// @Override
	// public ResponseEntity<Object> handleMethodArgumentNotValid(
	// 	MethodArgumentNotValidException ex,
	// 	HttpHeaders headers,
	// 	HttpStatusCode status,
	// 	WebRequest request
	// ) {
	// 	ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, "Invalid request parameter");
	//
	// 	Stream<FieldErrorItem> fieldErrors = ex.getBindingResult()
	// 		.getFieldErrors()
	// 		.stream()
	// 		.map(FieldErrorItem::new);
	//
	// 	problemDetail.setProperty("errors", fieldErrors);
	//
	// 	return super.handleExceptionInternal(ex, problemDetail, headers, status, request);
	// }
}
