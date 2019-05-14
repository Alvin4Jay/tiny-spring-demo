package com.jay.tinyspring.beans.factory;

/**
 * BeanFactory Interface Bean容器
 *
 * @author xuanjian
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

}
