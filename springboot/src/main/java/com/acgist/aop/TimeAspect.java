package com.acgist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(TimeAspect.class);
	
	@Pointcut("@annotation(com.acgist.aop.TimePoint)")
//	@Pointcut("execution(* com.acgist.service.*.create(..))")
	private void point() {
	}
	
	@Around("point()")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		TimePoint sign = getAnnotation(pjp); // 注解
		Long begin = System.currentTimeMillis();
		try {
			Object result = pjp.proceed();
			return result;
		} catch (Exception e) {
			throw e;
		} finally {
			Long end = System.currentTimeMillis();
			Long executeTime = end - begin;
			if(executeTime > sign.time()) {
				LOGGER.info(sign.name() + "执行时间：" + executeTime);
			}
		}
	}

	private TimePoint getAnnotation(ProceedingJoinPoint pjp) throws Exception, SecurityException {
		TimePoint sign = null;
		if (pjp.getSignature() instanceof MethodSignature) {
			MethodSignature ms = (MethodSignature) pjp.getSignature();
			sign = ms.getMethod().getAnnotation(TimePoint.class);
		}
		return sign;
	}
	
}
