package com.jay.tinyspring.aop;

/**
 * 切点通知器
 *
 * @author xuanjian
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
