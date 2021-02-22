package Tools;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Save {


    public static final String xmlFilePath = "score.xml";
    public Save()
    {

    }

    public void main() throws IOException, SAXException, ParserConfigurationException, TransformerException {



            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document copyfrom = documentBuilder.parse(xmlFilePath);
            Document copyto = documentBuilder.newDocument();

            // root element
            Element Players = copyto.createElement(String.valueOf(copyfrom.getElementsByTagName("Players")));
            copyto.appendChild(Players);

            // employee element
            Element Player = copyto.createElement(String.valueOf(copyfrom.getElementsByTagName("Player")));

            Players.appendChild(Player);


            // name element
//            Element Name = document.createElement("Name");
//            Name.appendChild(document.createTextNode("yassin"));
//            Player.appendChild(Name);
//
//            // score element
//            Element lastname = document.createElement("Score");
//            lastname.appendChild(document.createTextNode("15"));
//            Player.appendChild(lastname);
//
//
//            // create the xml file
//            //transform the DOM Object to an XML File
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource domSource = new DOMSource(document);
//            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
//
//            // If you use
//             StreamResult result = new StreamResult(System.out);
//            // the output will be pushed to the standard output ...
//            // You can use that for debugging
//
//            transformer.transform(domSource, streamResult);
//
//            System.out.println("Done creating XML File");
//

    }
}
