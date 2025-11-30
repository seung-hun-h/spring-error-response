package seunghun.springerrorresponse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/users/{userId}")
	public String getUser(@PathVariable Long userId) {
		throw new UnsupportedOperationException("Not implemented yet");
	}
}
