package sfp.spring.boot.security.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

	@GetMapping("/v1")
	public String getStr() {
		return "ping";
	}
}
