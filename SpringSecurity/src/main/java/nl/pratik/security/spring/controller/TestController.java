package nl.pratik.security.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	
	@GetMapping("/")
	public String test() {
		System.out.println("Got the home call");
		return "home";
	}
}
