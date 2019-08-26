package mx.com.simojica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.WebApplicationInitializer;

import mx.com.simojica.aspects.ExpedientesPerformanceMonitorAdvisor;
import mx.com.simojica.aspects.ExpedientesPerformanceMonitorInterceptor;
import mx.com.simojica.aspects.ExpedientesServiceAspect;

@EnableAutoConfiguration
@SpringBootApplication
@EnableAspectJAutoProxy
public class ServletInitializer extends SpringBootServletInitializer implements WebApplicationInitializer {

	private static final Logger LOGGER = LogManager.getLogger(ServletInitializer.class);
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		LOGGER.debug("INIZIALIZANDO SPRING BOOT");
		return application.sources(ServletInitializer.class);
	}
	
	public static void main(String[] args) {
		LOGGER.debug("EN MAIN");
		SpringApplication.run(ServletInitializer.class, args);
	}
	
	@Bean
	public ExpedientesPerformanceMonitorAdvisor expedientesPerformanceMonitorAdvisor() {
		return new ExpedientesPerformanceMonitorAdvisor(expedientesPerformanceMonitorInterceptor());
	}
	
	@Bean
	public ExpedientesPerformanceMonitorInterceptor expedientesPerformanceMonitorInterceptor() {
		return new ExpedientesPerformanceMonitorInterceptor(true);
	}
	
	@Bean
	public ExpedientesServiceAspect expedientesServiceAspect(){
		return new ExpedientesServiceAspect();
	}	
}