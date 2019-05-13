package com.jay.tinyspring;

import com.jay.tinyspring.factory.AutowireCapableBeanFactory;
import com.jay.tinyspring.factory.BeanFactory;
import org.junit.Test;

/**
 * BeanFactoryTest
 *
 * @author xuanjian
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 1.初始化BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.Bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.jay.tinyspring.HelloWorldService");

        // 3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.注册BeanDefinition
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.sayHello();
    }

}