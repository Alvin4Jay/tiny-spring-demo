package com.jay.tinyspring.aop;

/**
 * 被代理对象
 *
 * @author xuanjian
 */
public class TargetSource {

    private Object target;

    private Class<?> targetClass;

    public TargetSource(Object target, Class<?> targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }
}
