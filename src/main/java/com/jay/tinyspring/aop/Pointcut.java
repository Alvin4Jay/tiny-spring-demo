package com.jay.tinyspring.aop;

/**
 * Pointcut
 *
 * @author xuanjian
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMather getMethodMatcher();

}
