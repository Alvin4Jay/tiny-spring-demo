package com.jay.tinyspring.aop;

import org.aopalliance.aop.Advice;

/**
 * Advisor
 *
 * @author xuanjian
 */
public interface Advisor {

    Advice getAdvice();

}
