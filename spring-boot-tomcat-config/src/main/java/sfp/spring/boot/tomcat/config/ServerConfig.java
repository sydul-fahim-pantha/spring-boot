package sfp.spring.boot.tomcat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="server.tomcat") 
public class ServerConfig {
	
	private String acceptCount;
	
	
}
