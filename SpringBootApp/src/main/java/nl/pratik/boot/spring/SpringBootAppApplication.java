package nl.pratik.boot.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppApplication {
	
	public static final Logger logger = LoggerFactory.getLogger(SpringBootAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
		logger.warn("Loaded!");
	}

}
