package com.jay.tinyspring.factory;

import com.jay.tinyspring.BeanDefinition;

/**
 * BeanFactory Interface
 *
 * @author xuanjian
 */
public interface BeanFactory {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    Object getBean(String beanName);

}
