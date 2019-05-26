package com.jay.tinyspring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * AOP配置 代理相关的元数据
 *
 * @author xuanjian
 */
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMather methodMather;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMather getMethodMather() {
        return methodMather;
    }

    public void setMethodMather(MethodMather methodMather) {
        this.methodMather = methodMather;
    }
}
