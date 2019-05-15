package com.jay.tinyspring;

import com.jay.tinyspring.beans.BeanPostProcessor;

/**
 * BeanInitializationLogger  BeanPostProcessor Demo
 *
 * @author xuanjian
 */
public class BeanInitializationLogger implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " start!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " end!");
        return bean;
    }
}
