package com.jay.tinyspring.aop;

import java.lang.reflect.Method;

/**
 * AOP切点 方法匹配
 *
 * @author xuanjian
 */
public interface MethodMather {

    boolean match(Method method, Class<?> clazz);

}
