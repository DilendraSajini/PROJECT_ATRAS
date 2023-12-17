package org.atras.rest.web.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect{

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
			
	@Pointcut("@annotation(Loggable)")
	public void executeLogging() {
		
	}
	
	@Before("executeLogging()") // Advice
	public void logMethodCall(JoinPoint joinPoint) {
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		
		if(null != args && args.length>0) {
			message.append(" args=[ ");
			Arrays.asList(args).forEach(arg->{
				message.append(arg).append("|");
			});
			message.append("]");
		}
		LOGGER.info(message.toString());
	}
	
	@AfterReturning(value="executeLogging()", returning="returnValue") // Advice
	public void logMethodCall(JoinPoint joinPoint, Object returnValue) {
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		
		if(null != args && args.length>0) {
			message.append(" args=[ ");
			Arrays.asList(args).forEach(arg->{
				message.append(arg).append("|");
			});
			message.append("]");
		}
		if(returnValue != null) {
			message.append("Returning a Value"+returnValue.toString());	
		}
		LOGGER.info(message.toString());
	}

	// After throwing
	
	@Around(value="executeLogging()") // Advice
	public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object returnVal = joinPoint.proceed();
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinPoint.getSignature().getName());
		long totalTime = System.currentTimeMillis() - startTime;
		message.append("total Time:"+ totalTime);
		Object[] args = joinPoint.getArgs();
		
		if(null != args && args.length>0) {
			message.append(" args=[ ");
			Arrays.asList(args).forEach(arg->{
				message.append(arg).append("|");
			});
			message.append("]");
		}
		
		LOGGER.info(message.toString());
		return returnVal;
	}
	
}
