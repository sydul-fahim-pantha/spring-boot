package sfp.spring.boot.ssl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontCont {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
