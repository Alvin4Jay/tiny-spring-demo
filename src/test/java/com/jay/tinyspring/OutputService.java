package com.jay.tinyspring;

import org.junit.Assert;

/**
 * Class description here.
 *
 * @author xuanjian
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text) {
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
