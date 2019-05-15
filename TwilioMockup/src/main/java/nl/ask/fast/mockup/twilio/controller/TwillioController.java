package nl.ask.fast.mockup.twilio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwillioController {
	
	@GetMapping("/test/{id}")
	public String testHandler(@PathVariable("id") String id) {	
		return "You entered "+ id + " as your id"; 
	}

}
