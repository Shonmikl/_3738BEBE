package _2023_05_24;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

//парсим xml загружая весь документ в память
public class DOM {

    private static void printN(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if(nodeList.item(i) instanceof Element) {
                System.out.println(((Element) nodeList.item(i)).getTagName());
                if(nodeList.item(i).hasChildNodes()) {
                    printN(nodeList.item(i).getChildNodes());
                }
            }
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Предоставляет объект для парсинга документа xml
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src\\_2023_05_24\\1.xml"));

        //Содержит информацию о теге, атрибутах и содержимом
        Element element = document.getDocumentElement();
        System.out.println(element.getTagName());

        //
        NodeList nodeList = element.getChildNodes();
        printN(nodeList);
    }
}