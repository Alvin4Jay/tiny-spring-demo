package com.jay.tinyspring;

import org.junit.Assert;

/**
 * OutputServiceImpl
 *
 * @author xuanjian
 */
public class OutputServiceImpl implements OutputService {

    private HelloWorldService helloWorldService;

    @Override
    public void output(String text) {
//        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

}
