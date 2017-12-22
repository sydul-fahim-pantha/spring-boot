package sfp.spring.boot.jmx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmxExposer {

	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

	public void setSpittlesPerPage(int spittlesPerPage) {
		this.spittlesPerPage = spittlesPerPage;
	}

	public int getSpittlesPerPage() {
		return spittlesPerPage;
	}

	@GetMapping("/fields")
	public String page() {
		return "{spittlesPerPage: " +  spittlesPerPage + ", DEFAULT_SPITTLES_PER_PAGE: " + DEFAULT_SPITTLES_PER_PAGE + "}";
	}
}
