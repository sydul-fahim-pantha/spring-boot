package sfp.spring.boot.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController1 {

	@GetMapping("/ping")
	public String getStr() {
		return "pong";
	}
}
