package com.jay.tinyspring.context;

import com.jay.tinyspring.beans.BeanDefinition;
import com.jay.tinyspring.beans.factory.AbstractBeanFactory;
import com.jay.tinyspring.beans.factory.AutowireCapableBeanFactory;
import com.jay.tinyspring.beans.io.ResourceLoader;
import com.jay.tinyspring.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * ClassPath Xml ctx实现
 *
 * @author xuanjian
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(this.configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            this.beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
