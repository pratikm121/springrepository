package nl.pratik.thymeleaf.jpa.data.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataThymeleafApplication.class, args);
		System.out.println("Loaded");
	}

}
