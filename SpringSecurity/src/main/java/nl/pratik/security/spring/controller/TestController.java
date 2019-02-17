package nl.pratik.security.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//http://localhost:8080/SpringSecurity
@Controller
public class TestController {

	
	@GetMapping("/")
	public String test() {
		System.out.println("Got the home call");
		return "home";
	}
	
	@GetMapping("/leaders")
	public String leaders() {
		System.out.println("Got the leadercall");
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String sysAdmins() {
		System.out.println("Got the SysAdmins call");
		return "systems";
	}
}
