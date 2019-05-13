package com.jay.tinyspring;

/**
 * BeanDefinition
 *
 * @author xuanjian
 */
public class BeanDefinition {
    /**
     * Bean实例
     */
    private Object bean;
    /**
     * 全限定类名
     */
    private String beanClassName;
    /**
     * Class对象
     */
    private Class<?> beanClass;

    public BeanDefinition() {
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

}
