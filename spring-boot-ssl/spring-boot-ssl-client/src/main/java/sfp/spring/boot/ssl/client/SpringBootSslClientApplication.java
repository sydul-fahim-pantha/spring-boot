package sfp.spring.boot.ssl.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootSslClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslClientApplication.class, args);
	}
	
	@Autowired 
	private RestTemplate rest;
	
	@Override
	public void run(String... args) throws Exception {
		ResponseEntity<String> response = rest.getForEntity("https://localhost:8443/home", String.class);
		System.out.println(">>>>>>>>>>>>>>>>>>> " +response.getBody());
	}
}
