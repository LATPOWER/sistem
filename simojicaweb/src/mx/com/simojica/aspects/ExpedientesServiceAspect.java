package mx.com.simojica.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import mx.com.simojica.domain.Expediente;
import mx.com.simojica.exceptions.ExpedientesException;

@Aspect
public class ExpedientesServiceAspect {
	
	private static final Logger LOGGER = LogManager.getLogger(ExpedientesServiceAspect.class);
	@Pointcut("execution(* mx.com.simojica.service.ExpedienteService.guardarExpediente(..))")
	public void guardarExpediente() {
		
	}

	@Before("guardarExpediente()")
	public void beforeGuardarExpediente(JoinPoint joinPoint) {
		LOGGER.info("before guardar expediente");
	}

	@After("guardarExpediente()")
	public void afterGuardarExpediente(JoinPoint joinPoint) {
		LOGGER.info("Sucessfully guardarExpediente was executed");
	}

	@AfterReturning(pointcut = "guardarExpediente() and args(expediente)", returning = "isExpedientePersisted")
	public void afterTransferReturns(JoinPoint joinPoint, Expediente expediente,
			boolean isExpedientePersisted) {
		if (isExpedientePersisted) {
			LOGGER.info("Expediente salvado satisfactoriamente ");
			// find remaining balance of source account
		}
	}
	
	@AfterThrowing(pointcut = "guardarExpediente()", throwing = "expedientesException")
	public void exceptionFromTransfer(JoinPoint joinPoint, ExpedientesException expedientesException) {
		LOGGER.info("Exception thrown from guardarExpediente method: " + expedientesException.getMessage());
	}
	
	@Around("guardarExpediente()")
	public boolean aroundGuardarExpediente(ProceedingJoinPoint proceedingJoinPoint){
		LOGGER.info("Inside Around advice, before calling guardarExpediente method ");
		LOGGER.info("Inside Around advice, before calling guardarExpediente method proceedingJoinPoint "+proceedingJoinPoint);
		boolean isExpedientePersisted = false;
		try {
			isExpedientePersisted = (Boolean)proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			LOGGER.error( e);
		}
		LOGGER.info("Inside Around advice, after returning from guardarExpediente method");
		return isExpedientePersisted;
	}

}
