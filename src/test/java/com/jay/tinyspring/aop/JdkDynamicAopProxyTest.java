package com.jay.tinyspring.aop;

import com.jay.tinyspring.HelloWorldService;
import com.jay.tinyspring.context.ApplicationContext;
import com.jay.tinyspring.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Class description here.
 *
 * @author xuanjian
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void test() throws Exception {
        // 无AOP
        ApplicationContext ctx = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) ctx.getBean("helloWorldService");
        helloWorldService.sayHello();

        System.out.println("----------------------");

        // AOP
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        advisedSupport.setMethodInterceptor(new TimerInterceptor());

        // 3.创建代理(Proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        helloWorldService = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        // 4.基于AOP的调用
        helloWorldService.sayHello();
    }

}