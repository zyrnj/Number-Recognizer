import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class parse {
    public void parseXml() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document=builder.parse("./bookshelf.xml");
        System.out.println("Root element :" + document.getDocumentElement().getNodeName());
        NodeList bookList = document.getElementsByTagName("Book");
        int bookCount = bookList.getLength();

        for(int i=0; i<bookCount; i++){
            Node book = bookList.item(i);
            NodeList childNodes = book.getChildNodes();
            for(int j=0; j<childNodes.getLength(); j++){
                if(childNodes.item(j).getNodeType() == Node.ELEMENT_NODE){
                    System.out.println(childNodes.item(j).getNodeName()+"---" + childNodes.item(j).getTextContent());
                }
            }
        }
    }

    public void addXmlElement(){

    }
}
