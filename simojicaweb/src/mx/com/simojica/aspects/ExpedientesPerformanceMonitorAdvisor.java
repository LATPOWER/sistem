package mx.com.simojica.aspects;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ExpedientesPerformanceMonitorAdvisor extends DefaultPointcutAdvisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 415428476366153051L;
	
	
	public ExpedientesPerformanceMonitorAdvisor(ExpedientesPerformanceMonitorInterceptor expedientesPerformanceMonitorInterceptor) {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("mx.com.simojica.aspects.ExpedientesServiceAspect.guardarExpediente()");
		this.setPointcut(pointcut);
		this.setAdvice(expedientesPerformanceMonitorInterceptor);
	}

}
