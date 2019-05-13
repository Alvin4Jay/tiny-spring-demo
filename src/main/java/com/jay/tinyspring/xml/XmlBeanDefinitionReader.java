package com.jay.tinyspring.xml;

import com.jay.tinyspring.AbstractBeanDefinitionReader;
import com.jay.tinyspring.BeanDefinition;
import com.jay.tinyspring.PropertyValue;
import com.jay.tinyspring.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * 从xml配置中读取BeanDefinitions
 *
 * @author xuanjian
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinition(inputStream);
    }

    private void doLoadBeanDefinition(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        registerBeanDefinitions(document);
        inputStream.close();
    }

    private void registerBeanDefinitions(Document document) {
        Element root = document.getDocumentElement();

        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element bean = (Element) node;
                processBeanDefinition(bean);
            }
        }
    }

    private void processBeanDefinition(Element bean) {
        String beanName = bean.getAttribute("name");
        String className = bean.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(className);

        processBeanProperty(bean, beanDefinition);

        getRegistry().put(beanName, beanDefinition);
    }

    private void processBeanProperty(Element bean, BeanDefinition beanDefinition) {
        NodeList properties = bean.getElementsByTagName("property");
        for (int i = 0; i < properties.getLength(); i++) {
            Node node = properties.item(i);
            if (node instanceof Element) {
                Element property = (Element) node;
                String propertyName = property.getAttribute("name");
                String propertyValue = property.getAttribute("value");
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, propertyValue));
            }
        }
    }
}
