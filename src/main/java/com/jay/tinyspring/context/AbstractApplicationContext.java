package com.jay.tinyspring.context;

import com.jay.tinyspring.beans.factory.AbstractBeanFactory;

/**
 * AbstractApplicationContext
 *
 * @author xuanjian
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    protected AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * refresh调用的时候进行BeanDefinition解析
     * @throws Exception
     */
    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }
}
