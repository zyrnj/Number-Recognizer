import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class parse {
    Document document;
    JSONObject obj;

    public parse() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document=builder.parse("./bookshelf.xml");
        File file=new File("bookshelf.json");
        String content = new String(Files.readAllBytes(Paths.get("bookshelf.json")));
        JSONParser jsonParser=new JSONParser();
        obj = (JSONObject)jsonParser.parse(content);
    }

    public void parseXml() throws Exception {
        System.out.println("Root element :" + document.getDocumentElement().getNodeName());
        NodeList bookList = document.getElementsByTagName("Book");
        int bookCount = bookList.getLength();

        for(int i=0; i<bookCount; i++){
            Node book = bookList.item(i);
            NodeList childNodes = book.getChildNodes();
            for(int j=0; j<childNodes.getLength(); j++){
                if(childNodes.item(j).getNodeType() == Node.ELEMENT_NODE){
                    System.out.print(childNodes.item(j).getNodeName()+":" + childNodes.item(j).getTextContent()+"---");
                }
            }
            System.out.println();
        }
    }
    public void addXmlElement(){
        Element e=document.createElement("Book");
        document.getDocumentElement().appendChild(e);
        Element e2=document.createElement("title");
        e2.setTextContent("Harry Potter and Goblet of Firee");
        e.appendChild(e2);

        Element e3=document.createElement("author");
        e.appendChild(e3);
        e3.setTextContent("J.K. Rowling");
        Element e4=document.createElement("publishedYear");
        e.appendChild(e4);
        e4.setTextContent("2000");
        Element e5=document.createElement("numberOfPages");
        e.appendChild(e5);
        e5.setTextContent("381");
    }

    public void parseJson() throws Exception {
        //System.out.println(obj.get("book"));
        JSONArray jsonArray=(JSONArray)obj.get("book");
        for(int i=0;i<jsonArray.size();i++){
            System.out.print("The "+(i+1)+"th book:");
            System.out.println(jsonArray.get(i));
        }
    }

    public void addJsonElement(){
        JSONArray jsonArray=(JSONArray)obj.get("book");
        JSONObject newobj=new JSONObject();
        newobj.put("numberOfPages",381);
        newobj.put("author","J.K. Rowling");
        newobj.put("publishedYear",2000);
        newobj.put("title","Harry Potter and Goblet of Firee");
        jsonArray.add(newobj);
    }
}
