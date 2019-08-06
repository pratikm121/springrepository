package nl.pratik.mvc.security.boot.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@GetMapping("/")
	public String welcome(Model model) {
		System.out.println("welocme");
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}

}
