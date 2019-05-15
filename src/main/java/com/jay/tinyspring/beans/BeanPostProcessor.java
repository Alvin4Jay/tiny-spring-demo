package com.jay.tinyspring.beans;

/**
 * BeanPostProcessor
 *
 * @author xuanjian
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}
