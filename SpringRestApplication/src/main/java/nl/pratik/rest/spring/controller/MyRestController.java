package nl.pratik.rest.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/SpringRestApplication/rest
@RestController
@RequestMapping("/rest")
public class MyRestController {
	
	//http://localhost:8080/SpringRestApplication/rest/test
	@GetMapping("/test")
	public String home() {
		System.out.println("Got the rest call");
		return "hello Wrodl";
	}

}
