package com.jay.tinyspring.aop;

import com.jay.tinyspring.HelloWorldService;
import com.jay.tinyspring.HelloWorldServiceImpl;
import com.jay.tinyspring.context.ApplicationContext;
import com.jay.tinyspring.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * CglibAopProxy Test
 *
 * @author <a href=mailto:xuweijay@gmail.com>xuanjian</a>
 */
public class CglibAopProxyTest {

    @Test
    public void testCglibAopProxy() throws Exception {
        // --------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.sayHello();

        // --------- helloWorldService with AOP
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldServiceImpl.class,
                HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        CglibAopProxy cglib2AopProxy = new CglibAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) cglib2AopProxy.getProxy();

        // 4. 基于AOP的调用
        helloWorldServiceProxy.sayHello();
    }
}