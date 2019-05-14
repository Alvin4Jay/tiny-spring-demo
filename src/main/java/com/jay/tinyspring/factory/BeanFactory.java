package com.jay.tinyspring.factory;

import com.jay.tinyspring.BeanDefinition;

/**
 * BeanFactory Interface Bean容器
 *
 * @author xuanjian
 */
public interface BeanFactory {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;

    Object getBean(String beanName) throws Exception;

}
