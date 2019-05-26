package com.jay.tinyspring.aop;

/**
 * 被代理对象
 *
 * @author xuanjian
 */
public class TargetSource {

    /**
     * 被代理实例
     */
    private Object target;
    /**
     * 被代理类
     */
    private Class<?> targetClass;
    /**
     * 被代理接口
     */
    private Class<?>[] interfaces;


    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class<?>... interfaces) {
        this.interfaces = interfaces;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

}
