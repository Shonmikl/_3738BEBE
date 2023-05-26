package _2023_05_24;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class STAX {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser =
                factory.createXMLStreamReader(new FileInputStream("src\\_2023_05_24\\1.xml"));

        while (parser.hasNext()) {
            int event = parser.next();
            if(event == XMLStreamConstants.END_ELEMENT) {
                System.out.println(parser.getLocalName());
            }
        }
    }
}