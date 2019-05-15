package com.jay.tinyspring.aop;

import com.jay.tinyspring.HelloWorldServiceImpl;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * AspectJExpressionPointcutTest
 *
 * @author xuanjian
 */
public class AspectJExpressionPointcutTest {

    private String expression = "execution(* com.jay.tinyspring.*.*(..))";

    @Test
    public void testClassFilter() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        boolean matches = pointcut.getClassFilter().match(HelloWorldServiceImpl.class);
        assertTrue(matches);
    }

    @Test
    public void testMethodMatcher() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        Method method = HelloWorldServiceImpl.class.getDeclaredMethod("sayHello");
        boolean matches = pointcut.getMethodMatcher().match(method, HelloWorldServiceImpl.class);
        assertTrue(matches);
    }

}