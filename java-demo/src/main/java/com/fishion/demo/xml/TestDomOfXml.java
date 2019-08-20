package com.fishion.demo.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年05月17日 14:49
 */
public class TestDomOfXml {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, ClassNotFoundException {
        // 获取 DocumentBuilderFactory
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        builderFactory.setValidating(false);
        builderFactory.setNamespaceAware(false);
        builderFactory.setIgnoringComments(true);
        builderFactory.setIgnoringElementContentWhitespace(false);
        builderFactory.setCoalescing(false);
        builderFactory.setExpandEntityReferences(true);

        // 通过 DocumentBuilderFactory 获取 DocumentBuilder
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("warning:" + exception.getMessage());
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error:" + exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("fatalError:" + exception.getMessage());
            }
        });

        // 得到Document文件， 就是XML在JVM中的化身
        InputStream is = null;

        System.out.println(ClassLoader.getSystemClassLoader().loadClass("com.fishion.demo.xml.TestDomOfXml"));
        System.out.println(Class.forName("com.fishion.demo.xml.TestDomOfXml"));
        is = Class.forName("com.fishion.demo.xml.TestDomOfXml").getResourceAsStream("./cd.xml");
        Document document = builder.parse(is);

        // 以下通过 XPath 来获取对应的信息
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        // 解析 //CD//TITLE//text() ， 就是获取所有CD节点下TITLE子节点的文字内容
        XPathExpression expression = xPath.compile("//CD//TITLE//text()");

        Object result = expression.evaluate(document, XPathConstants.NODESET);
        NodeList nodeList = (NodeList) result;
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }
}
