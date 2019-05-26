package com.jay.tinyspring.beans.factory;

import com.jay.tinyspring.beans.BeanDefinition;
import com.jay.tinyspring.BeanReference;
import com.jay.tinyspring.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 具有自动装配能力的BeanFactory
 *
 * @author xuanjian
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 属性注入
     * @param bean 创建的Bean
     * @param beanDefinition Bean元数据
     * @throws Exception
     */
    @Override
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        // BeanFactory注入
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                // BeanReference处理
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                // setter注入
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + name.substring(0, 1).toUpperCase() + name.substring(1), value.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean, value);
            } catch (Exception e) {
                // field注入
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }

}
