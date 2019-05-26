package com.jay.tinyspring.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CglibAopProxy
 *
 * @author <a href=mailto:xuweijay@gmail.com>xuanjian</a>
 */
public class CglibAopProxy extends AbstractAopProxy {

    public CglibAopProxy(AdvisedSupport advised) {
        super(advised);
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.advised.getTargetSource().getTargetClass());
        enhancer.setInterfaces(this.advised.getTargetSource().getInterfaces());
        enhancer.setCallback(new DynamicAdvisedInterceptor(this.advised));
        return enhancer.create();
    }

    private static class DynamicAdvisedInterceptor implements MethodInterceptor {
        private AdvisedSupport advised;

        private org.aopalliance.intercept.MethodInterceptor delegateMethodInterceptor;

        private DynamicAdvisedInterceptor(AdvisedSupport advised) {
            this.advised = advised;
            delegateMethodInterceptor = advised.getMethodInterceptor();
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            MethodMather methodMather = this.advised.getMethodMather();
            if (methodMather == null
                    || methodMather.matches(method, advised.getTargetSource().getTargetClass())) {
                return delegateMethodInterceptor.invoke(
                        new CglibMethodInvocation(advised.getTargetSource().getTarget(), method, args, methodProxy));
            } else {
                return new CglibMethodInvocation(advised.getTargetSource().getTarget(), method, args, methodProxy).proceed();
            }
        }
    }

    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {
        private MethodProxy methodProxy;

        public CglibMethodInvocation(Object target, Method method, Object[] args, MethodProxy methodProxy) {
            super(target, method, args);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return methodProxy.invoke(this.target, this.args);
        }
    }

}
