package com.jay.tinyspring.aop;

import com.jay.tinyspring.beans.BeanPostProcessor;
import com.jay.tinyspring.beans.factory.AbstractBeanFactory;
import com.jay.tinyspring.beans.factory.BeanFactory;
import com.jay.tinyspring.beans.factory.BeanFactoryAware;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * AspectJAwareAdvisorAutoProxyCreator
 *
 * @author xuanjian
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {

    private AbstractBeanFactory beanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof Advisor) {
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }

        List<AspectJExpressionPointcutAdvisor> advisors =
                beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                ProxyFactory factory = new ProxyFactory();
                factory.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                factory.setMethodMather(advisor.getPointcut().getMethodMatcher());

                TargetSource targetSource = new TargetSource(bean, bean.getClass(), bean.getClass().getInterfaces());
                factory.setTargetSource(targetSource);
                return factory.getProxy();
            }
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (AbstractBeanFactory) beanFactory;
    }
}
