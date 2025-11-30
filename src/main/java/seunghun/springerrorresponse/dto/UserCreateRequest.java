package seunghun.springerrorresponse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UserCreateRequest(
	@NotBlank String name,
	@Positive Integer age
) {
}
