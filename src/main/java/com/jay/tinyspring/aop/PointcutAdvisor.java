package com.jay.tinyspring.aop;

/**
 * Class description here.
 *
 * @author xuanjian
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
