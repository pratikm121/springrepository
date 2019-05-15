package nl.ask.fast.mockup.twilio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioApplicationStarter {
	
	public static final Logger log = LoggerFactory.getLogger(TwilioApplicationStarter.class);

	public static void main(String[] args) {
		SpringApplication.run(TwilioApplicationStarter.class, args);
		log.warn("Loaded");
	}

}
