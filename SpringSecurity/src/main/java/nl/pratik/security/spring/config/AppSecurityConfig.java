package nl.pratik.security.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private DataSource springDS;			
	
	/*This method is used for authentication/authorization of 
	 * username ,password and roles for users from database.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(springDS);
	}
	
	/*This method is used for authentication/authorization of 
	 * hardcoded username ,password and roles for users.
	 */
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser(users.username("employee").password("employee").roles("EMPLOYEE"))
			.withUser(users.username("admin").password("admin").roles("EMPLOYEE","ADMIN"))			
			.withUser(users.username("manager").password("manager").roles("EMPLOYEE","MANAGER"));
	}*/
	
	/*This method is used for custom Login page and url,
	 * instead of using Spring security default login page.*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")			// This will allow all users with EMPLOYEE role to access all pages.
		.antMatchers("/leaders/**").hasRole("MANAGER")	// This will allow all users with MANAGER role to access all pages under /leaders.
		.antMatchers("/systems/**").hasRole("ADMIN")	// This will allow all users with ADMIN role to access all pages under /systems.
		.and().formLogin()
		.loginPage("/login")							//Login Page URL
		.loginProcessingUrl("/authenticateUser")		//Spring's Own Authentication Url
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling()
		.accessDeniedPage("/accessDenied");				// Custom Access Denied page Url.
	}

	
}
