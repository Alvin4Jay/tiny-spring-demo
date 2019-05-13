package com.jay.tinyspring;

/**
 * Bean属性及值 用于bean的属性注入
 *
 * @author xuanjian
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
