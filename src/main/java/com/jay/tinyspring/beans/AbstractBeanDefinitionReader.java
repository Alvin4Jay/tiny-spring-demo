package com.jay.tinyspring.beans;

import com.jay.tinyspring.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 从配置中读取BeanDefinitions
 * AbstractBeanDefinitionReader具有具体BeanDefinitionReader实现的公共属性resourceLoader/registry
 *
 * @author xuanjian
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 存放临时的BeanDefinitions
     */
    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
