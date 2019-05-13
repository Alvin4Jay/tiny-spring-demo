package com.jay.tinyspring.io;

import java.io.InputStream;

/**
 * Resource是spring内部定位资源的接口。
 *
 * @author xuanjian
 */
public interface Resource {

    InputStream getInputStream() throws Exception;

}
