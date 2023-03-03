/*
    Java Read XML – Java DOM Parser Example
    https://howtodoinjava.com/java/xml/read-xml-dom-parser-example/
    File xml demo: Jv_Data.xml
*/

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Jv_App { 
    public static void main(String argv[]) throws Exception{  
        File xmlFile = new File("src/Jv_Data.xml");  

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
        Document doc = db.parse(xmlFile);  

        NodeList list = doc.getElementsByTagName("StudentList");  
        Node node = list.item(0);
        Element element = (Element) node;
        String classes = element.getElementsByTagName("Class").item(0).getTextContent();
        System.out.println("Class: " + classes);
        System.out.println("-------------------------");
        System.out.println("    Code          Name         Marks");
        System.out.println("|----------|-----------------|--------");

        list = doc.getElementsByTagName("Student");
        for (int i = 0; i < list.getLength(); i++){
            String code, name, marks;
            node = list.item(i);  
            element = (Element) node;
            code = element.getElementsByTagName("Code").item(0).getTextContent();
            name = element.getElementsByTagName("Name").item(0).getTextContent();
            marks = element.getElementsByTagName("Marks").item(0).getTextContent();
                    
            System.out.println(code + "\t\t" + name + "\t" +marks);
        } 
    }
}