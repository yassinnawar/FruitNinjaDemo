package Tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


public class Load {
    private Document doc;
    private File fXmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;

    public Load(File f) throws IOException, SAXException, ParserConfigurationException {

         dbFactory = DocumentBuilderFactory.newInstance();
         dBuilder = dbFactory.newDocumentBuilder();
        this.fXmlFile= f;
        read();


    }

    public  void read() throws IOException, SAXException {


            if(fXmlFile.exists())
            {
                Document d = dBuilder.parse(fXmlFile);
                d.getDocumentElement().normalize();
                //this.doc=d;
                printPlayer(d);
            }
            else
                {
                    Document d = dBuilder.newDocument();
                    //d.getDocumentElement().normalize();
                   // this.doc=d;
                   // printPlayer(d);
                }
      // String Name =  d.getDocumentElement().getNodeName()


    }



    private void printPlayer(Document Doc)
    {
        System.out.println("Root element :" + Doc.getDocumentElement().getNodeName());

        NodeList nList = Doc.getElementsByTagName("Player");

        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) nNode;
                System.out.println("Name  : " + eElement.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println("Score : " + eElement.getElementsByTagName("Score").item(0).getTextContent());
            }
        }

    }
}
