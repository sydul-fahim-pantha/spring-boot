package sfp.spring.boot.redis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRedisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
