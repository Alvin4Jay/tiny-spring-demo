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
    public void test() {
        // 1.初始化BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.注册BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.jay.tinyspring.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.sayHello();
    }

}