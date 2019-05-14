package com.jay.tinyspring.beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * Class description here.
 *
 * @author xuanjian
 */
public class ResourceLoaderTest {
    @Test
    public void test() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream in = resource.getInputStream();
        Assert.assertNotNull(in);
    }
}