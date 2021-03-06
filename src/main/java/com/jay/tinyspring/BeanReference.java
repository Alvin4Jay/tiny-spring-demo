package com.jay.tinyspring;

/**
 * 属性ref Bean引用
 *
 * @author xuanjian
 */
public class BeanReference {
    /**
     * 引用的Bean name
     */
    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
