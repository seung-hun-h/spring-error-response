package seunghun.springerrorresponse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class UserNotFoundException extends BusinessException {
	public UserNotFoundException(String userId) {
		this(userId, null);
	}

	public UserNotFoundException(String userId, Throwable cause) {
		super(HttpStatus.NOT_FOUND, "User not found: " + userId, cause);
		getBody().setProperty("userId", userId);
	}
}
