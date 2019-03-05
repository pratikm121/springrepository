package nl.pratik.boot.spring.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="myendpoint")
@Component
public class CustomAppEndpoints {
	
	@ReadOperation
	@Bean
	public String hi() {
		return "Hi from custom endpoint";
	}

}
