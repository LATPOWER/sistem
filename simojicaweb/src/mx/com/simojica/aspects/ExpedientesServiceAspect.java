package mx.com.simojica.aspects;

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
	
	
	@Pointcut("execution(* mx.com.simojica.service.ExpedienteService.guardarExpediente(..))")
	public void guardarExpediente() {}

	@Before("guardarExpediente()")
	public void beforeTransfer(JoinPoint joinPoint) {
		System.out.println("before guardar expediente");
	}

	@After("guardarExpediente()")
	public void afterTransfer(JoinPoint joinPoint) {
		System.out.println("Sucessfully guardarExpediente was executed");
	}

	@AfterReturning(pointcut = "guardarExpediente() and args(expediente)", returning = "isExpedientePersisted")
	public void afterTransferReturns(JoinPoint joinPoint, Expediente expediente,
			boolean isExpedientePersisted) {
		if (isExpedientePersisted) {
			System.out.println("Expediente salvado satisfactoriamente ");
			// find remaining balance of source account
		}
	}
	
	@AfterThrowing(pointcut = "guardarExpediente()", throwing = "expedientesException")
	public void exceptionFromTransfer(JoinPoint joinPoint, ExpedientesException expedientesException) {
		System.out.println("Exception thrown from guardarExpediente method: " + expedientesException.getMessage());
	}
	
	@Around("guardarExpediente()")
	public boolean aroundTransfer(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Inside Around advice, before calling guardarExpediente method ");
		boolean isExpedientePersisted = false;
		try {
			isExpedientePersisted = (Boolean)proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			System.out.println( e);
		}
		System.out.println("Inside Around advice, after returning from guardarExpediente method");
		return isExpedientePersisted;
	}

}
