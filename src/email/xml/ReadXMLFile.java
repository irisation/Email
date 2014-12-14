package email.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXMLFile {

    public static void main(String[] args) {
        try {
            File fXmlFile = new File("./resources/emailbox.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("email");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("email id : " + eElement.getAttribute("emailid"));
                    System.out.println("To : " + eElement.getElementsByTagName("toaddress").item(0).getTextContent());
                    System.out.println("From : " + eElement.getElementsByTagName("fromaddress").item(0).getTextContent());
                    System.out.println("Subject : " + eElement.getElementsByTagName("subject").item(0).getTextContent());
                    System.out.println("Body : " + eElement.getElementsByTagName("body").item(0).getTextContent());
                    System.out.println("Senddate : " + eElement.getElementsByTagName("senddate").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}