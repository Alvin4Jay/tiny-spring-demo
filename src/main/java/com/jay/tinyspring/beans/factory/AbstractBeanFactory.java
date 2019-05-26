package com.jay.tinyspring.beans.factory;

import com.jay.tinyspring.beans.BeanDefinition;
import com.jay.tinyspring.beans.BeanPostProcessor;

import java.util.ArrayList;
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

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

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
            //TODO 循环依赖的Bean AOP存在问题
            bean = initializeBean(bean, beanName);
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    /**
     * BeanPostProcessor处理
     */
    private Object initializeBean(Object bean, String beanName) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
        }
        //TODO init-method
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, beanName);
        }
        return bean;
    }

    /**
     * 创建Bean
     */
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        // 重点，解决bean循环依赖
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {

    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(beanName, beanDefinition);
        beanNames.add(beanName);
    }

    /**
     * 预初始化单例
     */
    public void preInstantiateSingletons() throws Exception {
        for (String beanName : beanNames) {
            getBean(beanName);
        }
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getBeansForType(Class<T> type) throws Exception {
        List<T> list = new ArrayList<>();
        for (String beanName : beanNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanName).getBeanClass())) {
                list.add((T)getBean(beanName));
            }
        }
        return list;
    }

}
