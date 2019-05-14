package com.jay.tinyspring.beans.factory;

import com.jay.tinyspring.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AbstractBeanFactory
 *
 * @author xuanjian
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private final List<String> beanNames = new ArrayList<>();
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + beanName + " is defined.");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            // lazy init
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(beanName, beanDefinition);
        beanNames.add(beanName);
    }

    /**
     * 预初始化单例
     */
    public void preInstantiateSingletons() throws Exception {
        Iterator<String> iterator = beanNames.iterator();
        while (iterator.hasNext()) {
            getBean(iterator.next());
        }
    }

    /**
     * 创建Bean
     *
     * @param beanDefinition {@link BeanDefinition}
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
