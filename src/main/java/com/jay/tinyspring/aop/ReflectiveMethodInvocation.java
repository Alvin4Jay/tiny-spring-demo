package com.jay.tinyspring.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * 反射调用的方法调用Invocation
 *
 * @author xuanjian
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    /**
     * 实际对象
     */
    protected Object target;

    /**
     * 实际方法
     */
    protected Method method;

    /**
     * 实际参数
     */
    protected Object[] args;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, args);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
