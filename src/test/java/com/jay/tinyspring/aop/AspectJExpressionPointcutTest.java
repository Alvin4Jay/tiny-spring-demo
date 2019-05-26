package com.jay.tinyspring.aop;

import com.jay.tinyspring.HelloWorldServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * AspectJExpressionPointcut Test
 *
 * @author xuanjian
 */
public class AspectJExpressionPointcutTest {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    @Before
    public void before() {
        String expression = "execution(* com.jay.tinyspring.*.*(..))";
        pointcut.setExpression(expression);
    }

    @Test
    public void testClassFilter() {
        boolean matches = pointcut.getClassFilter().matches(HelloWorldServiceImpl.class);
        assertTrue(matches);
    }

    @Test
    public void testMethodMatcher() throws NoSuchMethodException {
        Method method = HelloWorldServiceImpl.class.getDeclaredMethod("sayHello");
        boolean matches = pointcut.getMethodMatcher().matches(method, HelloWorldServiceImpl.class);
        assertTrue(matches);
    }

}