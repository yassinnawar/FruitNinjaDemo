package Tools;

import org.xml.sax.SAXException;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public class Main {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        Load l= new Load(new File("score.xml"));
    }
}