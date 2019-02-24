package nl.pratik.rest.spring.config;


import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "nl.pratik.rest.spring")
@PropertySource("classpath:persistence-postgres.properties")			// Load properties file from src/main/resources
public class AppConfg {
	
	@Autowired
	private Environment env;								//Env object to load property file values
	private Logger logger = Logger.getLogger(getClass().getName());
	
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
	public DataSource springDatasource() throws PropertyVetoException {
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
	
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;				
	}
	
	// need a helper method 
		// read environment property and convert to int
		
		private int getIntProperty(String propName) {
			
			String propVal = env.getProperty(propName);
			
			// now convert to int
			int intPropVal = Integer.parseInt(propVal);
			
			return intPropVal;
		}	
		
		@Bean
		public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException{
			
			// create session factorys
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
			
			// set the properties
			sessionFactory.setDataSource(springDatasource());
			sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
			sessionFactory.setHibernateProperties(getHibernateProperties());
			
			return sessionFactory;
		}
		
		@Bean
		@Autowired
		public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
			
			// setup transaction manager based on session factory
			HibernateTransactionManager txManager = new HibernateTransactionManager();
			txManager.setSessionFactory(sessionFactory);

			return txManager;
		}	
	
	
	
}
