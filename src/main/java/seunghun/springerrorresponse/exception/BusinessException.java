package seunghun.springerrorresponse.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public abstract class BusinessException extends ErrorResponseException {
	public BusinessException(HttpStatusCode status, String detail) {
		super(status, createProblemDetail(status, detail), null);
	}

	public BusinessException(HttpStatusCode status, String detail, Throwable cause) {
		super(status, createProblemDetail(status, detail), cause);
	}

	private static ProblemDetail createProblemDetail(HttpStatusCode status, String detail) {
		return ProblemDetail.forStatusAndDetail(status, detail);
	}
}
