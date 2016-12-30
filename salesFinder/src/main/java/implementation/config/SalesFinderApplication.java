package implementation.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SalesFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesFinderApplication.class, args);
	}
}
