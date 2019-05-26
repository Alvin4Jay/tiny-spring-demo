package com.jay.tinyspring.aop;

/**
 * Proxy Factory 根据TargetSource类型自动创建不同的代理(JDK/CGLib)
 *
 * @author <a href=mailto:xuweijay@gmail.com>xuanjian</a>
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

    @Override
    public Object getProxy() {
        return createProxy().getProxy();
    }

    private AopProxy createProxy() {
        Class<?> targetClass = this.getTargetSource().getTargetClass();
        Class<?>[] interfaces = this.getTargetSource().getInterfaces();
        if (targetClass.isInterface() || (interfaces != null && interfaces.length > 0)) {
            return new JdkDynamicAopProxy(this);
        } else {
            return new CglibAopProxy(this);
        }
    }

}
