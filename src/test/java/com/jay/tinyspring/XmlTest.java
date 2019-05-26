package com.jay.tinyspring;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Class description here.
 *
 * @author xuanjian
 */
public class XmlTest {
    @Test
    public void test() throws Exception {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream("tinyioc.xml");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(in);

        Element root = document.getDocumentElement();

        NodeList nodeList = root.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element e = (Element) node;
                String beanName = e.getAttribute("id");
                String className = e.getAttribute("class");
                System.out.println("beanName: " + beanName);
                System.out.println("className: " + className);


                NodeList nl = e.getChildNodes();
                for (int j = 0; j < nl.getLength(); j++) {
                    Node nn = nl.item(j);
                    if (nn instanceof Element) {
                        Element ee = (Element) nn;
                        System.out.println("\tproperty name: " + ee.getAttribute("name"));
                        System.out.println("\tproperty value: " + ee.getAttribute("value"));
                    }
                }

            }
        }


    }
}
