package com.jay.tinyspring.aop;

/**
 * AOP切点 类匹配
 *
 * @author xuanjian
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);

}
