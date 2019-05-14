package com.jay.tinyspring.beans;

/**
 * 从配置中读取BeanDefinitions
 *
 * @author xuanjian
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;

}
