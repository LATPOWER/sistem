package mx.com.simojica;

import java.sql.Date;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
import mx.com.simojica.persistence.entity.Expedientes;
import mx.com.simojica.persistence.repository.ExpedientesRepository;

@EnableAutoConfiguration
@SpringBootApplication
@EnableAspectJAutoProxy
public class ServletInitializer extends SpringBootServletInitializer implements WebApplicationInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("XXXXXXXXXXXXYYYYYYYAAAAAAAA");
		return application.sources(ServletInitializer.class);
	}
	
	public static void main(String[] args) {
		System.out.println("EN MAIN");
		SpringApplication.run(ServletInitializer.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner() {
//		return args -> {
//			
//			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX INSERTANDO XXXXXXXXXXXXXXXXXXXXX");
//			repository.save(new Expedientes(1l, "A","B","C", null,	null, "123", "10", null));
//			
//		};
//	}	

	@Bean
	public ExpedientesServiceAspect expedientesServiceAspect(){
		return new ExpedientesServiceAspect();
	}
	
	
	@Bean
	public ExpedientesPerformanceMonitorInterceptor performanceMonitorInterceptor() {
		return new ExpedientesPerformanceMonitorInterceptor(true);
	}
	
	

	@Bean
	public ExpedientesPerformanceMonitorAdvisor performanceMonitorAdvisor() {
		return new ExpedientesPerformanceMonitorAdvisor(performanceMonitorInterceptor());
	}
}
