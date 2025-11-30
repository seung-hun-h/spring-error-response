package seunghun.springerrorresponse.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import seunghun.springerrorresponse.dto.UserCreateRequest;
import seunghun.springerrorresponse.exception.UserNotFoundException;

@RestController
public class DemoController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/users/{userId}")
	public String getUser(@PathVariable Long userId) {
		// throw new UserNotFoundException("hello123", new IllegalArgumentException("wrong id"));
		throw new UnsupportedOperationException();
	}

	@PostMapping("/users")
	public String createUser(@Valid @RequestBody UserCreateRequest request) {
		return "ok";
	}
}
