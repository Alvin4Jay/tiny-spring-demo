package com.jay.tinyspring.factory;

import com.jay.tinyspring.BeanDefinition;
import com.jay.tinyspring.BeanReference;
import com.jay.tinyspring.PropertyValue;

import java.lang.reflect.Field;

/**
 * 具有自动装配能力的BeanFactory
 *
 * @author xuanjian
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        // 重点，解决bean循环依赖
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 属性注入
     * @param bean 创建的Bean
     * @param beanDefinition Bean元数据
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field field = bean.getClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                // BeanReference处理
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            field.set(bean, value);
        }
    }

}
