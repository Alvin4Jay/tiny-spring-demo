package com.jay.tinyspring.beans.xml;

import com.jay.tinyspring.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class description here.
 *
 * @author xuanjian
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("tinyioc.xml");
        Assert.assertTrue(reader.getRegistry().size() > 0);
    }


}