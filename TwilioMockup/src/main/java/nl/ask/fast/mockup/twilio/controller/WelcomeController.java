package nl.ask.fast.mockup.twilio.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class WelcomeController {
	
	public static final Logger log = LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	private Environment env;	
	
	@GetMapping("/welcome")
	public String welcomeHandler(Map<String,Object> model) {
		model.put("message", env.getProperty("welcome.message"));
		test();
		return "welcome"; 
	}	
	
	private void test() {
		final String uri = "http://localhost:9090/twilio/test/{id}";
	     
	    Map<String, String> params = new HashMap<>();
	    params.put("id", "100");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class, params);
	     
	    System.out.println(result);
	}
}
