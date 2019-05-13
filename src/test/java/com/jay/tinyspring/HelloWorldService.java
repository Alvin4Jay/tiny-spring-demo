package com.jay.tinyspring;

/**
 * 测试Bean
 *
 * @author xuanjian
 */
public class HelloWorldService {

    private String text;

    public void sayHello() {
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
