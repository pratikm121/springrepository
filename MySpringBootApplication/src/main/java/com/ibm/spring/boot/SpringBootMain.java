package com.ibm.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);  
		System.out.println("Hello World");
	}

}
