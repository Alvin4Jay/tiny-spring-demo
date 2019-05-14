package com.jay.tinyspring;

/**
 * 测试Bean
 *
 * @author xuanjian
 */
public class HelloWorldService {

    private String text;
    /** 循环依赖测试 */
    private OutputService outputService;

    public void sayHello() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public OutputService getOutputService() {
        return outputService;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
