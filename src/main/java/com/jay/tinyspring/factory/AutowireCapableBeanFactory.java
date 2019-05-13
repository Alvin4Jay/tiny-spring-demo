package com.jay.tinyspring.factory;

import com.jay.tinyspring.BeanDefinition;

/**
 * 具有自动装配能力的BeanFactory
 *
 * @author xuanjian
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
