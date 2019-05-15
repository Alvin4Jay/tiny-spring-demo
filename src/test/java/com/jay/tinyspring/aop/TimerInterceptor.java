package com.jay.tinyspring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Class description here.
 *
 * @author xuanjian
 */
public class TimerInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.nanoTime();

        System.out.println("Invocation of method " + invocation.getMethod().getName() + " start!");

        Object result = invocation.proceed();

        System.out.println("Invocation of Method " + invocation.getMethod().getName() + " end! takes " + (System.nanoTime() - start)
                + " nanoseconds.");

        return result;
    }
}
