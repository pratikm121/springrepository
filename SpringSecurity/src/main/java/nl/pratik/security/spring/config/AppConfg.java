package nl.pratik.security.spring.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "nl.pratik.security.spring")
@PropertySource("classpath:persistence-postgres.properties")			// Load properties file from src/main/resources
public class AppConfg {
	
	@Autowired
	private Environment env;								//Env object to load property file values
	
	/*
	 * This method helps setup the view resolver properties from xml. 
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".jsp");
		return view;
	}
	
	
	/*
	 * This method helps setup the default Spring Security enabled datasource 
	 * from c3po connection pooling. 
	 */
	@Bean
	public DataSource springSecurityDatasource() throws PropertyVetoException {
		ComboPooledDataSource springDS = new ComboPooledDataSource();
		
		springDS.setDriverClass(env.getProperty("jdbc.driver"));
		springDS.setJdbcUrl(env.getProperty("jdbc.url"));
		springDS.setPassword(env.getProperty("jdbc.password"));
		springDS.setUser(env.getProperty("jdbc.user"));
		
		springDS.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		springDS.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		springDS.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		springDS.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		return springDS;
	}
	
	
	
}
