package mx.com.simojica.aspects;

import java.time.Instant;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

public class ExpedientesPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -792449718674563662L;
	
	
	public ExpedientesPerformanceMonitorInterceptor() {
		
		
	}
	
	
	public ExpedientesPerformanceMonitorInterceptor(boolean useMYLogger) {
		setUseDynamicLogger(useMYLogger);
	}

	@Override
	protected Object invokeUnderTrace(MethodInvocation invocation, Log log) throws Throwable {
		String name = createInvocationTraceName(invocation);
        long start = System.currentTimeMillis();
        log.info("Method " + name + " execution started at:" + Instant.now());
        try {
            return invocation.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            log.info("Method "+name+" execution lasted:"+time+" ms");
            log.info("Method "+name+" execution ended at:"+Instant.now());
             
            if (time > 5){
                log.warn("Method execution took longer than 5 ms!");
            } 
        }
	}

}
