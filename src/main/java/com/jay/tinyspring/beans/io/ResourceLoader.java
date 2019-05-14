package com.jay.tinyspring.beans.io;

import java.net.URL;

/**
 * Resource加载器
 *
 * @author xuanjian
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resourceUrl = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resourceUrl);
    }

}
