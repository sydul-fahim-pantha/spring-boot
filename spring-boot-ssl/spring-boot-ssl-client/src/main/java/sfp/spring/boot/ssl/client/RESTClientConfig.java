package sfp.spring.boot.ssl.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RESTClientConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
