package sfp.spring.boot.jmx.config.mbean.infoassembler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/MethodNameBasedInfoAssemblerController")
public class MethodNameBasedInfoAssemblerController {

	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;

	public void setSpittlesPerPage(int spittlesPerPage) {
		this.spittlesPerPage = spittlesPerPage;
	}

	public int infoAssemblerMethod1() {
		return spittlesPerPage;
	}

	@GetMapping("/assember-fields")
	public String page() {
		return "{spittlesPerPage: " +  spittlesPerPage + ", DEFAULT_SPITTLES_PER_PAGE: " + DEFAULT_SPITTLES_PER_PAGE + "}";
	}
}
