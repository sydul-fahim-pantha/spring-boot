package sfp.spring.boot.logsio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contrl {

	private static final Logger logger = LoggerFactory.getLogger(Contrl.class);
	
	@GetMapping("/info")
	public String log() {
		logger.info(">>>>>>>>>>>>>> info");
		System.out.println("info");
		return "info";
	}
	
	@GetMapping("/debug")
	public String debug() {
		logger.debug(">>>>>>>>>>>>>> debug");
		System.out.println("debug");
		return "debug";
	}
	
	@GetMapping("/err")
	public String err() {
		logger.error(">>>>>>>>>>>>>> err");
		System.out.println("error");
		return "error";
	}
	
	@GetMapping("/warn")
	public String warn() {
		logger.warn(">>>>>>>>>>>>>> warn");
		System.out.println("warn");
		return "warn";
	}
}
