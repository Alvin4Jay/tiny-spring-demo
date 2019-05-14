package com.jay.tinyspring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性集合
 * 包装一个对象所有的PropertyValue。<br/>
 * 为什么封装而不是直接用List?因为可以封装一些操作。
 *
 * @author xuanjian
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        // TODO:这里可以对于重复propertyName进行判断，直接用list没法做到
        this.propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

}
