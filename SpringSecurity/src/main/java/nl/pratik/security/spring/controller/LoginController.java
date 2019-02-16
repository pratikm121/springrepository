package nl.pratik.security.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		System.out.println("Got the login call");
		//return "loginPage";
		return "bootstrapLogin";
	}
}
