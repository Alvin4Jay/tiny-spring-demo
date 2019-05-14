package com.jay.tinyspring.context;

import com.jay.tinyspring.HelloWorldService;
import org.junit.Test;

/**
 * ApplicationContextTest
 *
 * @author xuanjian
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) ctx.getBean("helloWorldService");
        helloWorldService.sayHello();
    }

}