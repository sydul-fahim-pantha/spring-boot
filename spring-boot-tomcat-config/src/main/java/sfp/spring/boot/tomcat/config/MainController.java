package sfp.spring.boot.tomcat.config;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired  private ServerConfig config; 
	
	@GetMapping("/config")
	public String home() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> acc" + config.getAcceptCount());
		return "config: " + config.getAcceptCount();
	}
	
	@GetMapping("/sleep/hour")
	public String sleepHour(@RequestParam int hour) throws InterruptedException {
		Date date = new Date();				
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> hour");
		Thread.sleep(TimeUnit.HOURS.toMillis(hour));
		
		return "I am sleeping since " + date;
	}
	
	@GetMapping("/sleep/min")
	public String sleepMin(@RequestParam int min) throws InterruptedException {
		Date date = new Date();				

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> min");
		Thread.sleep(TimeUnit.MINUTES.toMillis(min));
		
		return "I am sleeping since " + date;
	}
	
	@GetMapping("/sleep/sec")
	public String sleepSec(@RequestParam int sec) throws InterruptedException {
		Date date = new Date();				

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> sec");
		Thread.sleep(TimeUnit.SECONDS.toMillis(sec));
		
		return "I am sleeping since " + date;
	}
}
