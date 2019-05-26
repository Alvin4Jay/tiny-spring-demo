package com.jay.tinyspring.context;

import com.jay.tinyspring.beans.BeanPostProcessor;
import com.jay.tinyspring.beans.factory.AbstractBeanFactory;

import java.util.List;

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

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }

    /**
     * refresh调用的时候进行BeanDefinition解析
     */
    public void refresh() throws Exception {
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    private void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        List<BeanPostProcessor> beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void onRefresh() throws Exception {
        // getBean("helloWorldService");
        beanFactory.preInstantiateSingletons();
    }

}
