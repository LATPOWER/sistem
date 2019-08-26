package mx.com.simojica.persistence;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:application.properties"})
@ComponentScan({"mx.com.simojica"})
@EnableJpaRepositories(basePackages = "mx.com.simojica")
public class HibernateJPAConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPackagesToScan("mx.com.simojica.persistence");
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		localContainerEntityManagerFactoryBean.setJpaProperties(additionalProperties());
		return localContainerEntityManagerFactoryBean;
	}
	
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public DataSource dataSource() {
		DataSource  dataSource = null;
		try {
			 Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("jdbc/simojica");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		return dataSource;
	}

	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	@Bean
	  public PersistenceExceptionTranslationPostProcessor 
	    exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	  }
	 private Properties additionalProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("hibernate.dialect",    environment.getProperty("hibernate.dialect"));
	    properties.setProperty("hibernate.generate_statistics",   environment.getProperty("hibernate.generate_statistics"));
	    properties.setProperty("hibernate.show_sql",   environment.getProperty("hibernate.show_sql"));
	    properties.setProperty("hibernate.cache.use_second_level_cache",   environment.getProperty("hibernate.cache.use_second_level_cache"));
	    properties.setProperty("hibernate.cache.use_query_cache",   environment.getProperty("hibernate.cache.use_query_cache"));
	    properties.setProperty("hibernate.cache.region.factory_class",  environment.getProperty("hibernate.cache.region.factory_class"));
	     return properties;
	  }
}
