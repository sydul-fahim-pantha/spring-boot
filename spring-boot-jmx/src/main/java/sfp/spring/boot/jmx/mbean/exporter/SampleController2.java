package sfp.spring.boot.jmx.mbean.exporter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/con2")
public class SampleController2 {

	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	private int spittlesPerPage2 = DEFAULT_SPITTLES_PER_PAGE;

	public void setSpittlesPerPage2(int spittlesPerPage) {
		this.spittlesPerPage2 = spittlesPerPage;
	}

	public int getSpittlesPerPage2() {
		return spittlesPerPage2;
	}

	@GetMapping("/field2s")
	public String page() {
		return "{spittlesPerPage: " +  spittlesPerPage2 + ", DEFAULT_SPITTLES_PER_PAGE: " + DEFAULT_SPITTLES_PER_PAGE + "}";
	}
}
