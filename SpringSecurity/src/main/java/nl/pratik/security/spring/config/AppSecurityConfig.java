package nl.pratik.security.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser(users.username("employee").password("employee").roles("EMPLOYEE"))
			.withUser(users.username("admin").password("admin").roles("EMPLOYEE","ADMIN"))			
			.withUser(users.username("manager").password("manager").roles("EMPLOYEE","MANAGER"));
	}
	
	/*This method is used for custom Login page and url,
	 * instead of using Spring security default login page.*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE")
		//.anyRequest().authenticated()				/*This is used for access to all for any page*/
		//.antMatchers("/").hasRole("*")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and().formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/authenticateUser")
		.permitAll()
		.and().logout().permitAll();
	}

	
}
