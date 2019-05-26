package com.jay.tinyspring.aop;

/**
 * AbstractAopProxy
 *
 * @author <a href=mailto:xuweijay@gmail.com>xuanjian</a>
 */
public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advised;

    protected AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
