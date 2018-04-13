package com.acgist.aop;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法时间统计
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE })
@Inherited
public @interface TimePoint {
	
	/**
	 * 任务名称
	 */
	String name() default "";
	
	/**
	 * 时间阀值：默认4秒
	 */
	long time() default 4L * 1000;
	
}
