package com.jay.tinyspring.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Resource加载器
 *
 * @author xuanjian
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection connection = url.openConnection();
        return connection.getInputStream();
    }
}
