package com.jay.tinyspring;

import com.jay.tinyspring.factory.AutowireCapableBeanFactory;
import com.jay.tinyspring.factory.BeanFactory;
import com.jay.tinyspring.io.ResourceLoader;
import com.jay.tinyspring.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * BeanFactoryTest
 *
 * @author xuanjian
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 1.读取bean配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        for (Map.Entry<String, BeanDefinition> beanDefinition : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinition.getKey(), beanDefinition.getValue());
        }

        // 3.获取Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.sayHello();
    }

}